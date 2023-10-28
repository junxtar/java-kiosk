package product.service;

import product.model.Product;

import java.util.List;

import static example.ExamProduct.PRODUCTS;

public class ProductService {
   List<Product> products = PRODUCTS;

   public Product findByCategoryIdAndProductId(int categoryId, int productId) {
      return products.stream()
              .filter(p -> p.getCategoryId() == categoryId && p.getProductId() == productId)
              .findFirst().orElse(null);
   }

   public List<Product> findByProducts(int id) {
      return products.stream().filter(p -> p.getCategoryId() == id).toList();
   }

   public int getOrdersTotalPrice (List<Product> products) {
      return products.stream().mapToInt(Product::getPrice).sum();
   }
}
