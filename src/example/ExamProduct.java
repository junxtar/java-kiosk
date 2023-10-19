package example;

import model.Pizza;
import model.Topping;

import static example.ExamCategory.PIZZA;
import static example.ExamCategory.TOPPING;

public class ExamProduct {
   // pizza
   public final static Pizza PEPPERONI = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "페퍼로니 피자", "피자러버들의 함성소리가 들립니다. 무슨 말이 필요할까요", 18000);
   public final static Pizza CHEESE = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "치즈 피자", "토핑이 없어도 이렇게 맛있을 수 있구나. 감탄 준비하세요", 18000);
   public final static Pizza HAWAIIAN = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "하와이안 피자", "진지하게 말씀드리지만 맛있습니다.(내피셜)", 18000);
   public final static Pizza SWEET_POTATO = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "고구마 피자", "피자계의 입문코스이자, 한국의 3대장 피자 중 하나", 18000);
   public final static Pizza BULGOGI = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "불고기 피자", "한국과 이탈리아의 최고의 콜라보!", 18000);

   // topping
   public final static Topping BACON = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "베이컨", "피자에 감칠맛과 짭쪼름함을 더하다", 2000);
   public final static Topping POTATO = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "감자", "피자에 고소함을 더하다", 2000);
   public final static Topping MEAT = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "고기", "피자의 허전함을 식감으로 채우다", 3000);
   public final static Topping MUSHROOM = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "버섯", "건강과 식감을 챙기고 싶다면 선택!", 1500);

   // beverage

   // sauce

   // side

   // method
   //TODO: 모든 메뉴 담기
}
