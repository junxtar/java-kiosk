package util.context;

import java.util.Scanner;

public class UtilContext {
   public static Scanner sc = new Scanner(System.in);
   public static void line() {
      System.out.println("--------------------------------------------------------");
   }
   public static  int validInput(int minValue, int maxValue, int input) {
      while (input < minValue || input > maxValue) {
         line();
         System.out.println("[ 잘못된 입력입니다. ]");
         System.out.println("  다시 입력 바랍니다.: ");
         input = sc.nextInt();
      }
      return input;
   }
}
