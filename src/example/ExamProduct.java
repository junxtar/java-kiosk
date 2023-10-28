package example;

import pizza.model.Pizza;
import product.model.Product;

import java.util.List;

import static example.ExamCategory.BEVERAGE;
import static example.ExamCategory.PIZZA;
import static example.ExamCategory.SAUCE;
import static example.ExamCategory.SIDE;

public class ExamProduct {
   // pizza
   public final static Pizza PEPPERONI = new Pizza(PIZZA.getCategoryId(), PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           1, "PEPPERONI_PIZZA", "피자러버들의 함성소리가 들립니다. 무슨 말이 필요할까요", 18000);
   public final static Pizza CHEESE = new Pizza(PIZZA.getCategoryId(), PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           2, "CHEESE_PIZZA", "토핑이 없어도 이렇게 맛있을 수 있구나. 감탄 준비하세요", 18000);
   public final static Pizza HAWAIIAN = new Pizza(PIZZA.getCategoryId(), PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           3, "HAWAIIAN_PIZZA", "진지하게 말씀드리지만 맛있습니다.(내피셜)", 18000);
   public final static Pizza SWEET_POTATO = new Pizza(PIZZA.getCategoryId(), PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           4, "SWEET_POTATO_PIZZA", "피자계의 입문코스이자, 한국의 3대장 피자 중 하나", 18000);
   public final static Pizza BULGOGI = new Pizza(PIZZA.getCategoryId(), PIZZA.getCategoryName(), PIZZA.getCategoryInformation(),
           5, "BULGOGI_PIZZA", "한국과 이탈리아의 최고의 콜라보!", 18000);

   // beverage
   public final static Product COKE = new Product(BEVERAGE.getCategoryId(), BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           1, "COKE", "코카콜라는 국룰 아시죠!?", 2000);
   public final static Product ZERO_COKE = new Product(BEVERAGE.getCategoryId(), BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           2, "ZERO_COKE", "주인장은 다이어트 때문에 이걸 마십니다!", 2000);
   public final static Product ICE_TEA = new Product(BEVERAGE.getCategoryId(), BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           3, "ICE_TEA", "달달한 복숭아~", 2500);
   public final static Product AMERICANO = new Product(BEVERAGE.getCategoryId(), BEVERAGE.getCategoryName(), BEVERAGE.getCategoryInformation(),
           4, "AMERICANO", "달콤 쌈싸름한 커피!", 1500);
   // sauce
   public final static Product GARLIC_DIPPING = new Product(SAUCE.getCategoryId(), SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           1, "GARLIC_DIPPING", "도우에 찍어먹으면 찰떡궁합", 500);
   public final static Product CHILI = new Product(SAUCE.getCategoryId(), SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           2, "CHILI", "새콤 달콤 매콤 3개의 조합", 500);
   public final static Product HOT = new Product(SAUCE.getCategoryId(), SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           3, "HOT", "매콤함으로 새로운 맛을 내봐요!", 500);
   public final static Product MUSTARD = new Product(SAUCE.getCategoryId(), SAUCE.getCategoryName(), SAUCE.getCategoryInformation(),
           4, "MUSTARD", "겨자씨를 이용해 달콤함을 구현한 소스!", 500);
   // side
   public final static Product SPAGHETTI = new Product(SIDE.getCategoryId(), SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           1, "SPAGHETTI", "피자와 스파게티는 한몸입니다.", 6500);
   public final static Product BUFFALO_WINGS = new Product(SIDE.getCategoryId(), SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           2, "BUFFALO_WINGS(5EA)", "저희 가게는 수제 버팔로 윙을 직접 사용합니다.", 5500);
   public final static Product CHEESE_BALL = new Product(SIDE.getCategoryId(), SIDE.getCategoryName(), SIDE.getCategoryInformation(),
           3, "CHEESE_BALL(5EA)", "치즈가 쭈우우욱 늘어나유~", 4500);

   // service
   public final static Product TAKE_OUT_SERVICE = new Product(0,"", "", 0, "TAKE_OUT_EVENT","",-2000);
   public final static List<Product> PRODUCTS = List.of(
           PEPPERONI,
           CHEESE,
           HAWAIIAN,
           SWEET_POTATO,
           BULGOGI,
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
