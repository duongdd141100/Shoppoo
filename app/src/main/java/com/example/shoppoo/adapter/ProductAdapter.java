package com.example.shoppoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Product;

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
        holder.tvImage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.product_icon, 0, 0, 0);
        holder.tvPrice.setText("$ " + products.get(position).getPrice().toString());
        holder.tvName.setText(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    protected class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvImage;
        private TextView tvPrice;
        private TextView tvName;
        private ProductAdapter adapter;
        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvImage = itemView.findViewById(R.id.tv_image);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
            this.tvName = itemView.findViewById(R.id.tv_name);
        }


        @Override
        public void onClick(View v) {
        }
    }
}
