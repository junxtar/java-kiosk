package model.kiosk;

import model.category.Category;
import model.category.CategoryService;
import model.order.Order;
import model.order.OrderService;
import model.order.OrderStatus;
import model.product.Product;
import model.product.ProductService;

import java.util.HashMap;
import java.util.List;

public class KioskMessage extends Util {

   private static final int OK = 1;
   private static final int CANCEL = 2;
   private static final int GUEST = 1;
   private static final int ADMIN = 2;
   private static final int TAKE_OUT = 1;
   private static final int DINE_IN = 2;
   private static final int ORDER = 5;
   private static final int CLEAR = 6;

   CategoryService categoryService = new CategoryService();
   ProductService productService = new ProductService();
   OrderService orderService = new OrderService();

   public void line() {
      System.out.println("--------------------------------------------------------");
   }

   public void helloMessage() {
      System.out.println("Junxtar Pizza 에 오신걸 환영합니다!");
   }

   public boolean isGuest() {
      int command = getValidUserRoleInput();

      return command == GUEST;
   }

   public int getValidUserRoleInput() {
      int command;
      while (true) {
         line();
         System.out.printf("%20s\n", "[손님] | [관리자] 여부를 선택해주세요.");
         System.out.printf("%-20s\n", "1.손님 2.관리자");
         command = sc.nextInt();
         if (command == GUEST || command == ADMIN) {
            break;
         }
         System.out.println("[ 잘못된 입력입니다. ]");
      }
      return command;
   }

   public OrderStatus isTakeOut() {
      return getValidOrderStatusInput() == 1 ? OrderStatus.TAKE_OUT : OrderStatus.DINE_IN;
   }

   public int getValidOrderStatusInput() {
      int command;
      while (true) {
         line();
         System.out.printf("%20s\n", "[포장] | [매장] 여부를 선택해주세요.");
         System.out.printf("%-20s\n", "1.포장 주문 2.매장 주문");
         command = sc.nextInt();
         if (command == TAKE_OUT || command == DINE_IN) {
            break;
         }
         System.out.println("[ 잘못된 입력입니다. ]");
      }
      return command;
   }

   public Order ordering(Order order) {
      while (true) {
         int categoryId = showMenu();
         if (categoryId >= 1 && categoryId <= categoryService.getCategoriesSize()) {
            selectMenu(categoryId, order);
         } else if (categoryId == ORDER) {
            System.out.println("아래와 같이 주문 하시겠습니까?\n");
            System.out.println("[ Orders ]");
            HashMap<Product, Integer> map = order.getProductMap();
            for (Product product : map.keySet()) {
               System.out.printf("%-18s | %8d 개 | %-8d ₩ | %-20s\n", product.getProductName(), map.get(product), product.getPrice(), product.getProductInformation());
            }
            System.out.println();
            System.out.println("[ Total ]");
            int totalPrice = orderService.getTotalPrice(map);
            System.out.printf("%-8d ₩\n", totalPrice);
            System.out.println();
            System.out.printf("%-20s\n", "1.주문   2.메뉴판");
            int command = validInput(CANCEL, sc.nextInt());
            if (command == OK) {
               return order;
            } else {
               System.out.println("메뉴판으로 돌아갑니다.");
            }
         } else if (categoryId == CLEAR) {
            orderService.orderCancel(order);
         } else {
            System.out.println("[ 잘못된 입력입니다. ]");
         }
      }
   }

   private int showMenu() {
      line();
      int idx = 1;
      System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
      System.out.println("[ Junxtar Pizza MENU ]");
      List<Category> categories = categoryService.findCategories();
      for (Category category : categories) {
         System.out.printf("%2d. %-10s | %-20s\n", idx++, category.getCategoryName(), category.getCategoryInformation());
      }
      System.out.println();
      System.out.println("[ ORDER MENU ]");
      System.out.printf("%2d. %-10s | %-20s\n", idx++, "Order", "장바구니를 확인 후 주문합니다.");
      System.out.printf("%2d. %-10s | %-20s\n", idx++, "Cancel", "진행중인 주문을 취소하며, 장바구니를 초기화 합니다.");
      return sc.nextInt();
   }


   private void selectMenu(int categoryId, Order order) {
      List<Product> products = productService.findProducts(categoryId);
      line();
      for (Product p : products) {
         System.out.printf("%2d. %-18s | %-8d ₩ | %-20s\n", p.getProductId(), p.getProductName(), p.getPrice(), p.getProductInformation());
      }
      int productId = validInput(products.size(), sc.nextInt());

      Product product = productService.findByCategoryIdAndProductId(categoryId, productId);
      line();
      System.out.printf("%-18s | %-8d ₩ | %-20s\n", product.getProductName(), product.getPrice(), product.getProductInformation());
      System.out.printf("%-20s\n", "1.확인      2.취소");
      int command = validInput(CANCEL, sc.nextInt());
      if (command == OK) {
         order.addProductMap(product);
         order.addProduct(product);
         System.out.printf("%-18s 가 장바구니에 추가되었습니다.\n\n", product.getProductName());
      }
      if (command == CANCEL) {
         System.out.println("메뉴 선택이 취소되었습니다.\n");
      }
   }

   public void successOrder(Order order) {
         System.out.println("주문이 완료되었습니다!\n");
         System.out.println("대기 번호는 [ " + order.getId() + " ] 번 입니다.");
         System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
         // thread? 3sec ? -> run();
   }

   private int validInput(int maxValue, int input) {
      while (input < OK || input > maxValue) {
         line();
         System.out.println("[ 잘못된 입력입니다. ]");
         System.out.println("  다시 입력 바랍니다.: ");
         input = sc.nextInt();
      }
      return input;
   }

}