package com.iniesta.iniesta_revew;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ItemDetailFragent extends Fragment {

    LinearLayout review, buynow, rating ;
    TextView price1, name1;
    ImageView image;
    String imageUrl, textname;
    int textprice;

    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_item_detail_fragent, container, false);

       review = view.findViewById(R.id.review);
       buynow = view.findViewById(R.id.buynow);
       rating = view.findViewById(R.id.rating);
       price1 = view.findViewById(R.id.price);
       name1 = view.findViewById(R.id.name);
       image = view.findViewById(R.id.item_image2);

        Log.i("aman",imageUrl);

        Glide.with(getContext())
                .load(imageUrl)
                .placeholder(R.drawable.back)
                .into(image);

        price1.setText("Price :"+textprice+" in India");
        name1.setText(textname);

        return view;
    }

    public void getData(String urla, String name, int price)
    {
        imageUrl = urla;
        textname = name;
        textprice = price;
    }



}
