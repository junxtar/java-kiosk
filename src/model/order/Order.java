package model.order;

import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {

   private int id;
   private final List<Product> products = new ArrayList<>();
   private final HashMap<Product, Integer> productMap = new HashMap<>();
   private OrderStatus orderStatus;

   public int getId() {
      return id;
   }

   public List<Product> getProducts() {
      return products;
   }

   public HashMap<Product, Integer> getProductMap() {
      return productMap;
   }

   public String getOrderStatus() {
      return orderStatus.getStatus();
   }

   public void setOrderStatus(OrderStatus orderStatus) {
      this.orderStatus = orderStatus;
   }

   public void addProduct(Product p) {
      this.products.add(p);
   }

   public void addProductMap(Product product) {
      productMap.put(product, productMap.getOrDefault(product, 0) + 1);
   }

   public Order successOrder() {
      System.out.println(getOrderStatus() + "주문이 완료되었습니다!");
      System.out.println("대기 번호는 [ " + getId() + " ] 번 입니다.");
      // thread? 3sec ? -> run();
      return this;
   }

}
