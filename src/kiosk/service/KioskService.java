package kiosk.service;

import product.model.Product;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static util.context.UtilContext.line;
import static util.context.UtilContext.sc;

public class KioskService {
   private static final int GUEST = 1;
   private static final int ADMIN = 2;
   private static final String SYSTEM_PASSWORD = "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";

   private final List<Product> products = new ArrayList<>();
   KioskGuestService kioskGuestService = new KioskGuestService();
   KioskManagerService kioskManagerService = new KioskManagerService();

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

   public void guestMode() throws InterruptedException {
      kioskGuestService.displayGuestMode(products);
   }

   public void managerMode() {
      kioskManagerService.displayManagerMode(products);
   }

   public boolean passwordCheck() throws NoSuchAlgorithmException {
      line();
      System.out.print("관리자 비밀번호를 입력해주세요: ");

      return encryption(String.valueOf(sc.nextInt())).equals(SYSTEM_PASSWORD);
   }

   public void passwordNotMatchMessage() {
      System.out.println("비밀번호가 일치하지 않습니다.");
      System.out.println("시스템이 돌아갑니다.");
   }

   private String encryption(String password) throws NoSuchAlgorithmException {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(password.getBytes());

      return bytesToHex(md.digest());
   }

   private String bytesToHex(byte[] bytes) {
      StringBuilder sb = new StringBuilder();
      for (byte b : bytes) {
         sb.append(String.format("%02x", b));
      }
      return sb.toString();
   }
}