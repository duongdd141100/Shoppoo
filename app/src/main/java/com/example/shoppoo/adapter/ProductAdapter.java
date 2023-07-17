package com.example.shoppoo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.ProductDetailActivity;
import com.example.shoppoo.R;
import com.example.shoppoo.entity.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    private List<Product> products;

    private Context context;
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.id = products.get(position).getId();
        Picasso.with(context).load("error").error(R.drawable.product_icon).placeholder(R.drawable.product_icon).into(holder.tvImage);
        holder.tvPrice.setText("$ " + products.get(position).getPrice().toString());
        holder.tvName.setText(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    protected class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Long id;

        private ImageView tvImage;
        private TextView tvPrice;
        private TextView tvName;
        private ProductAdapter adapter;
        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvImage = itemView.findViewById(R.id.tv_image);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
            this.tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("id", id);
            context.startActivity(intent);
        }
    }
}
