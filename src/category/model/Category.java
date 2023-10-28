package category.model;

public class Category {

   private final int categoryId;
   private final String categoryName;
   private final String categoryInformation;

   public Category(int id, String categoryName, String categoryInformation) {
      this.categoryId = id;
      this.categoryName = categoryName;
      this.categoryInformation = categoryInformation;
   }

   public int getCategoryId() {
      return categoryId;
   }

   public String getCategoryName() {
      return categoryName;
   }

   public String getCategoryInformation() {
      return categoryInformation;
   }

}
