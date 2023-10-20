package model.order;

import model.product.Product;

import java.util.Map;

public class OrderService {

   public void orderCancel(Order order) {
      order.getProductMap().clear();
      order.getProducts().clear();
   }

   public int getTotalPrice(Map<Product, Integer> productMap) {
      int totalPrice = 0;
      for (Product product : productMap.keySet()) {
         totalPrice += product.getPrice() * productMap.get(product);
      }
      return totalPrice;
   }

}
