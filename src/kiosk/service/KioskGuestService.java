package kiosk.service;

import category.model.Category;
import category.service.CategoryService;
import order.model.Order;
import order.model.OrderStatus;
import order.service.OrderService;
import pizza.model.Pizza;
import pizza.model.Size;
import product.model.Product;
import product.service.ProductService;

import java.util.HashMap;
import java.util.List;

import static util.context.UtilContext.line;
import static util.context.UtilContext.sc;
import static util.context.UtilContext.validInput;

public class KioskGuestService {

   private static final int TAKE_OUT = 1;
   private static final int DINE_IN = 2;
   private static final int OK = 1;
   private static final int CANCEL = 2;
   private static final int ORDER = 5;
   private static final int CLEAR = 6;

   OrderService orderService = new OrderService();
   CategoryService categoryService = new CategoryService();
   ProductService productService = new ProductService();

   public void displayGuestMode(List<Product> products) throws InterruptedException {
      Order order = orderService.initOrder();
      order.setOrderStatus(isTakeOut());
      products.addAll(ordering(order).getProducts());
      successOrder(order);
   }

   private OrderStatus isTakeOut() {
      return getValidOrderStatusInput() == 1 ? OrderStatus.TAKE_OUT : OrderStatus.DINE_IN;
   }

   private int getValidOrderStatusInput() {
      int command;
      while (true) {
         line();
         System.out.println("[ 포장 주문 EVENT ] 18000원 이상 구매시 2000원 할인 ");
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

   private Order ordering(Order order) {
      while (true) {
         int categoryId = showMenu();
         if (categoryId >= 1 && categoryId <= categoryService.getCategoriesSize()) {
            selectMenu(categoryId, order);
         } else if (categoryId == ORDER) {
            System.out.println("아래와 같이 주문 하시겠습니까?\n");
            System.out.println("[ Orders ]");
            HashMap<Product, Integer> map = order.getProductMap();
            int totalPrice = orderService.getTotalPrice(map);
            order = getDiscountedOrder(order, totalPrice);
            totalPrice = orderService.getTotalPrice(map);
            for (Product product : map.keySet()) {
               System.out.printf("%-24s | %4d 개 | %-8d ₩ | %-20s\n", product.getProductName(), map.get(product), product.getPrice(), product.getProductInformation());
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.printf("%-8d ₩\n", totalPrice);
            System.out.println();
            System.out.printf("%-20s\n", "1.주문   2.메뉴판");
            int command = validInput(OK, CANCEL, sc.nextInt());
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
      System.out.printf("%2d. %-10s | %-20s\n", idx, "Cancel", "진행중인 주문을 취소하며, 장바구니를 초기화 합니다.");
      return sc.nextInt();
   }

   private void selectMenu(int categoryId, Order order) {
      List<Product> products = productService.findByProducts(categoryId);
      line();
      for (Product p : products) {
         System.out.printf("%2d. %-18s | %-8d ₩ | %-20s\n", p.getProductId(), p.getProductName(), p.getPrice(), p.getProductInformation());
      }
      int productId = validInput(OK, products.size(), sc.nextInt());

      Product product = productService.findByCategoryIdAndProductId(categoryId, productId);
      line();
      System.out.printf("%-18s | %-8d ₩ | %-20s\n", product.getProductName(), product.getPrice(), product.getProductInformation());
      product = optionSizeOfPizza(product);
      System.out.printf("%-20s\n", "1.확인      2.취소");
      int command = validInput(OK, CANCEL, sc.nextInt());
      if (command == OK) {
         order.addProductMap(product);
         order.addProduct(product);
         System.out.printf("%-18s 가 장바구니에 추가되었습니다.\n\n", product.getProductName());
      }
      if (command == CANCEL) {
         System.out.println("메뉴 선택이 취소되었습니다.\n");
      }
   }

   private Order getDiscountedOrder(Order order, int totalPrice) {
      if (totalPrice >= 18000 && order.getOrderStatus().equals(OrderStatus.TAKE_OUT.getStatus())) {
         order = orderService.addTakeOutService(order);
      }
      return order;
   }

   private Product optionSizeOfPizza(Product product) {
      if (product instanceof Pizza) {
         System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까? ");
         int idx = 1;
         for (Size s : Size.values()) {
            System.out.printf("%2d. %2s(%-4d W)\n", idx++, s.getSize(), product.getPrice() + s.getPrice());
         }
         int command = validInput(1, Size.values().length, sc.nextInt());
         String pizzaName = product.getProductName();
         int pizzaPrice = product.getPrice();
         if (command == 1) {
            ((Pizza) product).setSize(Size.SMALL);
         } else if (command == 2) {
            ((Pizza) product).setSize(Size.MEDIUM);
         } else {
            ((Pizza) product).setSize(Size.LARGE);
         }
         pizzaName += "(" + ((Pizza) product).getSize() + ")";
         pizzaPrice += ((Pizza) product).getSize().getPrice();
         line();
         System.out.printf("%-18s | %-8d ₩ | %-20s\n", pizzaName, pizzaPrice, product.getProductInformation());
         return new Product(product.getCategoryId(), product.getCategoryName(), product.getCategoryInformation(),
                 product.getProductId(), pizzaName, product.getProductInformation(), pizzaPrice);
      }
      return product;
   }

   private void successOrder(Order order) throws InterruptedException {
      System.out.println("주문이 완료되었습니다!\n");
      System.out.println("대기 번호는 [ " + order.getId() + " ] 번 입니다.");
      System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
      for (int i = 0; i < 3; i++) {
         Thread.sleep(1000);
         System.out.println(3 - i + "....");
      }
   }
}
