package model.category;

import java.util.List;

import static example.ExamCategory.BEVERAGE;
import static example.ExamCategory.PIZZA;
import static example.ExamCategory.SAUCE;
import static example.ExamCategory.SIDE;

public class CategoryService {

   public List<Category> findCategories() {
      return List.of(PIZZA, BEVERAGE, SAUCE, SIDE);
   }

   public int getCategoriesSize() {
      return List.of(PIZZA, BEVERAGE, SAUCE, SIDE).size();
   }

}
