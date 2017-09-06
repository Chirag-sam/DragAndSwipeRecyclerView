package com.example.chirag.dragandswiperecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  RecyclerView rvFoodItems;
  FoodAdapter foodAdapter;
  ArrayList<FoodItemBean> foodList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    foodList = (ArrayList) DataSource.createListItems();

    rvFoodItems = findViewById(R.id.rvFoodItems);
    rvFoodItems.setLayoutManager(new LinearLayoutManager(this));
    rvFoodItems.setItemAnimator(new DefaultItemAnimator());

    foodAdapter = new FoodAdapter(foodList);
    rvFoodItems.setAdapter(foodAdapter);

    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
        new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

          @Override
          public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
              RecyclerView.ViewHolder target) {
            moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
          }

          @Override public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            deleteItem(viewHolder.getAdapterPosition());
          }
        });
    itemTouchHelper.attachToRecyclerView(rvFoodItems);
  }

  void moveItem(int oldPos, int newPos) {
    FoodItemBean fooditem = foodList.get(oldPos);

    foodList.remove(oldPos);
    foodList.add(newPos, fooditem);
    foodAdapter.notifyItemMoved(oldPos, newPos);
  }

  void deleteItem(final int position) {
    foodList.remove(position);
    foodAdapter.notifyItemRemoved(position);
  }
}
