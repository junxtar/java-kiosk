public class Category {
   private final String categoryName;
   private final String categoryInformation;

   public Category(String categoryName, String categoryInformation) {
      this.categoryName = categoryName;
      this.categoryInformation = categoryInformation;
   }

   public String getCategoryName() {
      return categoryName;
   }

   public String getCategoryInformation() {
      return categoryInformation;
   }
}
