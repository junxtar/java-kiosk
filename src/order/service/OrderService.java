package order.service;

import order.model.Order;
import product.model.Product;

import java.util.Map;

import static example.ExamProduct.TAKE_OUT_SERVICE;

public class OrderService {

   static int orderId = 1;
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

   public Order initOrder() {
      Order order = new Order();
      order.setId(orderId++);
      return order;
   }

   public Order addTakeOutService(Order order) {
      order.addProduct(TAKE_OUT_SERVICE);
      order.addProductMap(TAKE_OUT_SERVICE);
      return order;
   }

}
