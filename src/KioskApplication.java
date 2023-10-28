import kiosk.controller.KioskController;

import java.security.NoSuchAlgorithmException;

public class KioskApplication {
   public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
      KioskController kioskController = new KioskController();
      kioskController.run();
   }
}
