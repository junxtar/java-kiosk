package model.pizza;

public enum Size {
   SMALL("S", -5000),
   MEDIUM("M", 0),
   LARGE("L", 5000);

   private String size;
   private int price;

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
