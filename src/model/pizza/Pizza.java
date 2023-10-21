package model.pizza;

import model.product.Product;

public class Pizza extends Product {

   private Size size;
   public Pizza(int categoryId, String categoryName, String categoryInformation, int productId, String productName, String productInformation, int price) {
      super(categoryId, categoryName, categoryInformation, productId, productName, productInformation, price);

   }
   public void setSize(Size size) {
      this.size = size;
   }

}
