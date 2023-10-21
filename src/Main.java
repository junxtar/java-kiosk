import model.kiosk.Kiosk;

import java.security.NoSuchAlgorithmException;

public class Main {
   public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException {
      Kiosk kisok = new Kiosk();
      kisok.run();
   }
}
