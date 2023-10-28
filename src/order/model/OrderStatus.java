package order.model;

public enum OrderStatus {

   TAKE_OUT("포장"),
   DINE_IN("매장 식사");

   private final String status;

   OrderStatus(String status) {
      this.status = status;
   }

   public String getStatus() {
      return status;
   }

}
