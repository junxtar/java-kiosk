package kiosk.controller;

import kiosk.service.KioskService;
import order.model.Order;
import product.model.Product;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class KioskController {

   private final List<Product> products = new ArrayList<>();
   KioskService kioskService = new KioskService();
   public void run() throws InterruptedException, NoSuchAlgorithmException {
      helloMessage();
      if (isGuest()) {
         guestMode();
      } else {
         if (passwordCheck() && managerMode(products)) {
            run();
         } else {
            passwordNotMatchMessage();
            run();
         }
      }
   }
   public void helloMessage() {
      System.out.println("Junxtar Pizza 에 오신걸 환영합니다!");
   }

   private void guestMode() throws InterruptedException, NoSuchAlgorithmException {
      Order order = orderService.initOrder();
      order.setOrderStatus(isTakeOut());
      products.addAll(ordering(order).getProducts());
      successOrder(order);
      run();
   }
}
