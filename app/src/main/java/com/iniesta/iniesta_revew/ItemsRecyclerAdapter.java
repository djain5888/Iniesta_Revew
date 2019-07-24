package com.iniesta.iniesta_revew;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.ItemsViewHolder> {

    private Context mContext;
    private ArrayList<Item> itemsList;
    private RecyclerViewClickListener mListener;

    public ItemsRecyclerAdapter(Context context, ArrayList<Item> itemsList,RecyclerViewClickListener listener) {
        this.mContext = context;
        this.itemsList = itemsList;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ItemsRecyclerAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item,parent,false);
        return new ItemsViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsRecyclerAdapter.ItemsViewHolder holder, int position) {

        final Item item = itemsList.get(position);

        Glide.with(mContext)
                .load(item.getImageUrl())
                .placeholder(R.drawable.back)
                .into(holder.itemImageView);

        holder.itemTypeView.setText(item.getType());
        holder.itemNameView.setText(item.getName());
        holder.itemPriceView.setText(String.valueOf(item.getPrice()));

        holder.amazonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = item.getAmazonLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });

        holder.flipkartLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = item.getFlipkartLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemImageView;
        TextView itemTypeView;
        TextView itemNameView;
        TextView itemPriceView;
        ImageView flipkartLink;
        ImageView amazonLink;

        public RecyclerViewClickListener iListener;

        public ItemsViewHolder(@NonNull View itemView,RecyclerViewClickListener listener) {
            super(itemView);

            itemView.setOnClickListener(this);
            iListener = listener;

            itemImageView = itemView.findViewById(R.id.itemImage);
            itemTypeView = itemView.findViewById(R.id.itemType);
            itemNameView = itemView.findViewById(R.id.itemName);
            itemPriceView = itemView.findViewById(R.id.itemPrice);
            flipkartLink = itemView.findViewById(R.id.flipkartLink);
            amazonLink = itemView.findViewById(R.id.amazonLink);
        }


        @Override
        public void onClick(View view) {
            iListener.onClick(view, getAdapterPosition());
        }
    }
}
