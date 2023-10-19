package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
   private static long id = 0;
   private List<Product> products = new ArrayList<>();

   public static long getId() {
      return id;
   }

   public List<Product> getProducts() {
      return products;
   }

   public void addProduct(Product p) {
      this.products.add(p);
   }
   public int getTotalPrice() {
       return products.stream().mapToInt(Product::getPrice).sum();
   }
}
