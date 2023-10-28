package kiosk.service;

import product.model.Product;
import product.service.ProductService;

import java.util.List;

import static util.context.UtilContext.line;
import static util.context.UtilContext.sc;
import static util.context.UtilContext.validInput;

public class KioskManagerService {
   private static final int EXIT = 0;
   ProductService productService = new ProductService();

   public void displayManagerMode(List<Product> products) {
      line();
      System.out.println("[ 관리자 모드 ]");
      System.out.println("0. 시스템 종료");
      System.out.println("1. 총 판매 금액 확인");
      System.out.println("2. 총 판매 물품 확인");
      System.out.println("3. 홈 화면으로 돌아가기");
      int command = validInput(EXIT, 3, sc.nextInt());
      if (command == EXIT) {
         System.exit(0);
      }
      if (command == 1) {
         int totalPrice = productService.getOrdersTotalPrice(products);
         System.out.print("현재까지 판매한 금액: " + totalPrice + " ₩ 입니다.");
         System.out.println();
         System.out.println("1. 돌아가기");
         validInput(1, 1, sc.nextInt());
         displayManagerMode(products);
      }
      if (command == 2) {
         for (Product product : products) {
            System.out.printf("%-18s | %-8d ₩ \n", product.getProductName(), product.getPrice());
         }
         System.out.println();
         System.out.println("1. 돌아가기");
         validInput(1, 1, sc.nextInt());
         displayManagerMode(products);
      }
   }
}
