package com.igor.qcnoblefoods.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.igor.qcnoblefoods.R;
import com.igor.qcnoblefoods.adapters.ItemsRecyclerAdapter;
import com.igor.qcnoblefoods.models.Item;

import java.util.ArrayList;

public class ItemsListFragment extends Fragment {

    private static final String TAG = "ItemsListFragment";

    private ImageView ivBack;
    private RecyclerView mRecyclerView;

    private ArrayList<Item> mItems = new ArrayList<>();
    private ItemsRecyclerAdapter mItemsRecyclerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemslist,container,false);
        ivBack = view.findViewById(R.id.arrowBack);
        mRecyclerView = view.findViewById(R.id.recyclerview);



        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        initRecyclerView();
        insertItems();

        return view;

    }

    private void insertItems(){
        Item item = new Item();
        item.setImage("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        item.setName("Havasu Falls");
        item.setExpirationdate("25 may 1965");
        mItems.add(item);
        mItemsRecyclerAdapter.notifyDataSetChanged();
    }
    private void initRecyclerView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mItemsRecyclerAdapter = new ItemsRecyclerAdapter(mItems,getContext());
        mRecyclerView.setAdapter(mItemsRecyclerAdapter);
    }
}
