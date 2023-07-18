package com.example.shoppoo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Shop;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder>{

    public ShopAdapter(List<Shop> shops, Context context) {
        this.shops = shops;
        this.context = context;
    }

    private List<Shop> shops;

    private Context context;
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);
        return new ShopViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.tvName.setText(shops.get(position).getName());
        holder.tvFounder.setText(shops.get(position).getFounder());
        holder.tvCategory_id.setText(shops.get(position).getCategoryId().toString());
        holder.tvAddress.setText(shops.get(position).getAddress());
        holder.tvProduct_count.setText(shops.get(position).getProductCount().toString());
        holder.tvDescription.setText(shops.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    protected class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private TextView tvFounder;
        private TextView tvCategory_id;
        private TextView tvAddress;
        private TextView tvProduct_count;
        private TextView tvDescription;
        private ShopAdapter adapter;
        public ShopViewHolder(@NonNull View itemView, ShopAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvFounder = itemView.findViewById(R.id.tv_founder);
            this.tvCategory_id = itemView.findViewById(R.id.tv_category_id);
            this.tvAddress = itemView.findViewById(R.id.tv_address);
            this.tvProduct_count = itemView.findViewById(R.id.tv_product_count);
            this.tvDescription = itemView.findViewById(R.id.tv_description);
        }

        @Override
        public void onClick(View v) {
        }
    }
}


