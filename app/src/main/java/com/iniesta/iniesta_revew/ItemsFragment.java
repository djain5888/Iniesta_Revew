package com.iniesta.iniesta_revew;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemsFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_items, container, false);
        recyclerView = view.findViewById(R.id.items_recycler);

        ItemsRecyclerAdapter.RecyclerViewClickListener listener = new ItemsRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                String url = items.get(position).getImageUrl();
                Fragment detailFragment = new ItemDetailFragent();
                ((ItemDetailFragent) detailFragment).getData(url,items.get(position).getName(),items.get(position).getPrice());
                getFragmentManager().beginTransaction().replace(R.id.fragments_container,detailFragment).addToBackStack(null).commit();
            }
        };

        ItemsRecyclerAdapter adapter = new ItemsRecyclerAdapter(this.getContext(),items,listener);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void addItems(){
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/1.jpg","SONY S5","Mobile",15000,"https://www.amazon.in/","https://www.flipkart.com/"));
        items.add(new Item("http://curefit.xyz/shop/images/2.jpg","SAMSUNG GALAXY S5","Mobile",25000,"https://www.amazon.in/","https://www.flipkart.com/"));
    }

}
