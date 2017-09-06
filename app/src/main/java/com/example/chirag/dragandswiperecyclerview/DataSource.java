package com.example.chirag.dragandswiperecyclerview;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

  private static final String[] foodItems = { "Burger", "Pasta", "Chocolates", "Ice Cream" };

  private static final int[] foodImages =
      { R.drawable.burger, R.drawable.pasta, R.drawable.choc, R.drawable.icecream };

  public static List<FoodItemBean> createListItems() {

    List<FoodItemBean> items = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < foodItems.length && j < foodImages.length; j++) {

        FoodItemBean foodItemBean = new FoodItemBean();

        foodItemBean.setFoodItem(foodItems[j]);
        foodItemBean.setImgId(foodImages[j]);

        items.add(foodItemBean);
      }
    }

    return items;
  }
}
