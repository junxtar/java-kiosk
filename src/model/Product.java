package product;

import category.Category;

public class Product extends Category {

   private String productName;
   private String productInformation;
   private int price;

   public Product(String categoryName, String categoryInformation, String productName, String productInformation, int price) {
      super(categoryName, categoryInformation);
      this.productName = productName;
      this.productInformation = productInformation;
      this.price = price;
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
