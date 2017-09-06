package com.example.chirag.dragandswiperecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by gurkirat on 4/6/17.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

  List<FoodItemBean> foodItemList;

  public FoodAdapter(List<FoodItemBean> foodItemList) {
    this.foodItemList = foodItemList;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
    FoodItemBean foodItemBean = foodItemList.get(position);

    holder.imgFood.setImageResource(foodItemBean.getImgId());
    holder.txtFood.setText(foodItemBean.getFoodItem());
  }

  @Override public int getItemCount() {
    return foodItemList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imgFood;
    TextView txtFood;

    public ViewHolder(View itemView) {
      super(itemView);

      imgFood = itemView.findViewById(R.id.imgFood);
      txtFood = itemView.findViewById(R.id.txtFood);
    }
  }
}
