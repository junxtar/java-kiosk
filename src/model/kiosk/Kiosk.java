package model.kiosk;

import model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Kiosk extends KioskMessage {

   private final List<Order> orders = new ArrayList<>();

   public void run() {
      helloMessage();
      if (isGuest()) {
         Order order = new Order();
         order.setOrderStatus(isTakeOut());
         ordering(order);
      } else {
         line();
         System.out.print("관리자 비밀번호를 입력해주세요: ");
         int password = sc.nextInt();
         //관리자 모드
         if (passwordCheck(password)) {
            managerMode();
            int command = sc.nextInt();

         } else {
            run();
         }
      }
   }

   private boolean passwordCheck(int password) {
      return password == 1234;
   }

   public void managerMode() {
      line();
      System.out.println("[ 관리자 모드 ]");
      System.out.println("0.시스템 종료");
      System.out.println("1.총 판매 금액 확인");
      System.out.println("2.총 판매 물품 확인");
   }
}
