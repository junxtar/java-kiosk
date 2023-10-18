package example;

public class ExamProduct {
   public final Category pizza = new Category("피자", "쫄깃한 도우와 이탈리아 피자의 조합");
   public final Pizza PEPPERONI = new Pizza(pizza.getCategoryName(), pizza.getCategoryInformation(),
           "페퍼로니 피자", "피자러버들의 함성소리가 들립니다. 무슨 말이 필요할까요", 18000);
   public final Pizza CHEESE = new Pizza(pizza.getCategoryName(), pizza.getCategoryInformation(),
           "치즈 피자", "토핑이 없어도 이렇게 맛있을 수 있구나. 감탄 준비하세요", 18000);

}
