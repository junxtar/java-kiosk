package example;

import model.Beverage;
import model.Pizza;
import model.Product;
import model.Sauce;
import model.Side;
import model.Topping;

import java.util.List;

import static example.ExamCategory.BEVERAGE;
import static example.ExamCategory.PIZZA;
import static example.ExamCategory.SAUCE;
import static example.ExamCategory.SIDE;
import static example.ExamCategory.TOPPING;

public class ExamProduct {
   // pizza
   public final static Pizza PEPPERONI = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "PEPPERONI_PIZZA", "피자러버들의 함성소리가 들립니다. 무슨 말이 필요할까요", 18000);
   public final static Pizza CHEESE = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "CHEESE_PIZZA", "토핑이 없어도 이렇게 맛있을 수 있구나. 감탄 준비하세요", 18000);
   public final static Pizza HAWAIIAN = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "HAWAIIAN_PIZZA", "진지하게 말씀드리지만 맛있습니다.(내피셜)", 18000);
   public final static Pizza SWEET_POTATO = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "SWEET_POTATO_PIZZA", "피자계의 입문코스이자, 한국의 3대장 피자 중 하나", 18000);
   public final static Pizza BULGOGI = new Pizza(PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           "BULGOGI_PIZZA", "한국과 이탈리아의 최고의 콜라보!", 18000);
   // topping
   public final static Topping BACON = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "BACON", "피자에 감칠맛과 짭쪼름함을 더하다", 2000);
   public final static Topping POTATO = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "POTATO", "피자에 고소함을 더하다", 2000);
   public final static Topping MEAT = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "MEAT", "피자의 허전함을 식감으로 채우다", 3000);
   public final static Topping MUSHROOM = new Topping(TOPPING.getCategoryName(), TOPPING.getCategoryInformation(),
           "MUSHROOM", "건강과 식감을 챙기고 싶다면 선택!", 1500);
   // beverage
   public final static Beverage COKE = new Beverage(BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           "COKE", "코카콜라는 국룰 아시죠!?", 2000);
   public final static Beverage ZERO_COKE = new Beverage(BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           "ZERO_COKE", "주인장은 다이어트 때문에 이걸 마십니다!", 2000);
   public final static Beverage ICE_TEA = new Beverage(BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           "ICE_TEA", "달달한 복숭아~", 2500);
   public final static Beverage AMERICANO = new Beverage(BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           "AMERICANO", "달콤 쌈싸름한 커피!", 1500);
   // sauce
   public final static Sauce GARLIC_DIPPING = new Sauce(SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           "GARLIC_DIPPING", "도우에 찍어먹으면 찰떡궁합", 500);
   public final static Sauce CHILI = new Sauce(SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           "CHILI", "새콤 달콤 매콤 3개의 조합", 500);
   public final static Sauce HOT = new Sauce(SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           "HOT", "매콤함으로 새로운 맛을 내봐요!", 500);
   public final static Sauce MUSTARD = new Sauce(SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           "MUSTARD", "겨자씨를 이용해 달콤함을 구현한 소스!", 500);
   // side
   public final static Side SPAGHETTI = new Side(SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           "SPAGHETTI", "피자와 스파게티는 한몸입니다.", 6500);
   public final static Side BUFFALO_WINGS = new Side(SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           "BUFFALO_WINGS(5EA)", "저희 가게는 수제 버팔로 윙을 직접 사용합니다.", 5500);
   public final static Side CHEESE_BALL = new Side(SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           "CHEESE_BALL(5EA)", "치즈가 쭈우우욱 늘어나유~", 4500);

   public final static List<Product> PRODUCTS = List.of(
           PEPPERONI,
           CHEESE,
           HAWAIIAN,
           SWEET_POTATO,
           BULGOGI,
           BACON,
           POTATO,
           MEAT,
           MUSHROOM,
           COKE,
           ZERO_COKE,
           ICE_TEA,
           AMERICANO,
           GARLIC_DIPPING,
           CHILI,
           HOT,
           MUSTARD,
           SPAGHETTI,
           BUFFALO_WINGS,
           CHEESE_BALL
   );
}
