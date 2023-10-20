package model.product;

import java.util.List;

import static example.ExamProduct.PRODUCTS;

public class ProductService {

   List<Product> products = PRODUCTS;

   public Product findByCategoryIdAndProductId(int categoryId, int productId) {
      return products.stream()
              .filter(p -> p.getCategoryId() == categoryId && p.getProductId() == productId)
              .findFirst().get();
   }

   public List<Product> findProducts(int id) {
      return products.stream().filter(p -> p.getCategoryId() == id).toList();
   }

}
