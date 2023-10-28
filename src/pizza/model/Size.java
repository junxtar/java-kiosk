package pizza.model;

public enum Size {
   SMALL("S", -5000),
   MEDIUM("M", 0),
   LARGE("L", 5000);

   private final String size;
   private final int price;

   Size(String size, int price) {
      this.size = size;
      this.price = price;
   }

   public String getSize() {
      return size;
   }

   public int getPrice() {
      return price;
   }
}
