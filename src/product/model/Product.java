package product.model;

import category.model.Category;

public class Product extends Category {
   private final int productId;
   private final String productName;
   private final String productInformation;
   private final int price;

   public Product(int categoryId, String categoryName, String categoryInformation,int productId, String productName, String productInformation, int price) {
      super(categoryId, categoryName, categoryInformation);
      this.productId = productId;
      this.productName = productName;
      this.productInformation = productInformation;
      this.price = price;
   }

   public int getProductId() {
      return productId;
   }

   public String getProductName() {
      return productName;
   }

   public String getProductInformation() {
      return productInformation;
   }

   public int getPrice() {
      return price;
   }
}
