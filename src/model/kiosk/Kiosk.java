package model.kiosk;

import model.order.Order;
import model.product.Product;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Kiosk extends KioskMessage {

   private final List<Product> products = new ArrayList<>();

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

   private void guestMode() throws InterruptedException, NoSuchAlgorithmException {
      Order order = orderService.initOrder();
      order.setOrderStatus(isTakeOut());
      products.addAll(ordering(order).getProducts());
      successOrder(order);
      run();
   }
}
