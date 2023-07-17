package com.example.shoppoo.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder>{

    @NonNull
    @Override
    public ShopAdapter.ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ShopViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class  ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ShopAdapter adapter;
        public ShopViewHolder(@NonNull View itemView, ShopAdapter adapter) {
            super(itemView);
            this.adapter = adapter;

        }
        @Override
        public void onClick(View v) {

        }
    }
}
