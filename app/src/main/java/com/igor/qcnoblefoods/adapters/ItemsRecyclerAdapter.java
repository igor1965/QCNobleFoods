package com.igor.qcnoblefoods.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.igor.qcnoblefoods.MainActivity;
import com.igor.qcnoblefoods.R;
import com.igor.qcnoblefoods.models.Item;

import java.util.ArrayList;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.ViewHolder> {

    private ArrayList<Item> mItems  = new ArrayList<>();
    private Context mContext;

    public ItemsRecyclerAdapter(ArrayList<Item> items,Context mContext) {
        this.mItems = items;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Glide.with(mContext)
                .asBitmap()
                .load(mItems.get(i).getImage())
                //.load(R.drawable.halffaq)
                .into(viewHolder.itemImage);
        viewHolder.name.setText(mItems.get(i).getName());
        viewHolder.expirationDate.setText(mItems.get(i).getExpirationdate());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
          ImageView itemImage;
          TextView name,expirationDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.tvItemName);
            expirationDate = itemView.findViewById(R.id.tvExpirationDate);
        }
    }
}
