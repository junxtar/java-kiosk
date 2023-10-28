package order.model;

import product.model.Product;

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

   public void setId(int id) {
      this.id = id;
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

}
