package kiosk.controller;

import kiosk.service.KioskService;

import java.security.NoSuchAlgorithmException;

public class KioskController {

   KioskService kioskService = new KioskService();

   public void run() throws InterruptedException, NoSuchAlgorithmException {
      kioskService.helloMessage();
      if (kioskService.isGuest()) {
         kioskService.guestMode();
         run();
      } else {
         if (kioskService.passwordCheck()) {
            kioskService.managerMode();
            run();
         } else {
            kioskService.passwordNotMatchMessage();
            run();
         }
      }
   }
}
