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
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.repository.ProductRepository;

import java.util.List;

public class HistoryBoughtAdapter extends RecyclerView.Adapter<HistoryBoughtAdapter.HistoryBoughtViewHolder> {

    public HistoryBoughtAdapter(List<ProductStatus> productStatusList, Context context) {
        this.productStatusList = productStatusList;
        this.context = context;
        productRepo = new ProductRepository(this.context);
    }

    private List<ProductStatus> productStatusList;

    private Context context;

    private ProductRepository productRepo;
    @NonNull
    @Override
    public HistoryBoughtAdapter.HistoryBoughtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_bought_item, parent, false);
        return new HistoryBoughtAdapter.HistoryBoughtViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryBoughtAdapter.HistoryBoughtViewHolder holder, int position) {
        Product product = productRepo.findById(productStatusList.get(position).getProductId());
        holder.tvImage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.product_icon, 0, 0, 0);
        holder.tvQuantity.setText("Quantity: " + productStatusList.get(position).getQuantity());
        holder.tvPrice.setText("Price: " + productStatusList.get(position).getQuantity() * product.getPrice());
        holder.tvProductName.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return productStatusList.size();
    }

    protected class HistoryBoughtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvImage;
        private TextView tvQuantity;
        private TextView tvPrice;
        private TextView tvProductName;
        private HistoryBoughtAdapter adapter;
        public HistoryBoughtViewHolder(@NonNull View itemView, HistoryBoughtAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvImage = itemView.findViewById(R.id.tv_image);
            this.tvQuantity = itemView.findViewById(R.id.tv_quantity);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
            this.tvProductName = itemView.findViewById(R.id.tv_product_name);
        }


        @Override
        public void onClick(View v) {
        }
    }
}
