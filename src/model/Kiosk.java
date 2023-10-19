package model;

import model.order.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static example.ExamCategory.CATEGORIES;

// run

public class Kisok {
   static List<Category> categories = CATEGORIES;
   private final List<Order> orders = new ArrayList<>();

   public List<Order> getOrders() {
      return orders;
   }

   public void hellMessage() {
      System.out.println("Junxtar Pizza 에 오신걸 환영합니다!");
   }
   public void orderStatusMessage() {
      System.out.printf("%20s\n", "[포장] | [매장] 여부를 선택해주세요.");
      System.out.printf("%-20s\n","1.포장 주문 2.매장 주문");
   }

   public void line() {
      System.out.println("--------------------------------------------------------");
   }

   private static void showMenu() {
      int idx = 1;
      System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
      System.out.println("[ Junxtar Pizza MENU ]");
      for (Category category : categories) {
         System.out.printf("%2d. %-10s | %-20s\n", idx++, category.getCategoryName(), category.getCategoryInformation());
      }
      System.out.println();
      System.out.println("[ ORDER MENU ]");
      System.out.printf("%2d. %-10s | %-20s\n", idx++, "Order", "장바구니를 확인 후 주문합니다.");
      System.out.printf("%2d. %-10s | %-20s\n", idx++, "Cancel", "진행중인 주문을 취소합니다.");
   }

   public void run() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Order order = new Order();
      hellMessage();
      line();
      // 손님인지 관리자인지 묻고 선택하기
      check
      orderStatusMessage();
      int orderStatus = Integer.parseInt(br.readLine());
      order.checkOrderStatus(orderStatus);
      line();
      showMenu();
      int command = Integer.parseInt(br.readLine());

   }



   public void managerMode() {

   }
}
