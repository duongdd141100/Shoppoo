package com.example.shoppoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public CartAdapter(List<ProductStatus> productStatusList, MyCartListener myCartListener, Context context) {
        this.productStatusList = productStatusList;
        this.myCartListener = myCartListener;
        this.context = context;
        this.productRepo = new ProductRepository(context);
    }

    private List<ProductStatus> productStatusList;

    private Context context;

    private MyCartListener myCartListener;

    private ProductRepository productRepo;

    private List<String> productStatusSelectedIds = new ArrayList<>();

    private Boolean isSelectedAll = false;

    private Long totalPrice = 0L;

    private List<CheckBox> checkboxCheckedIds = new ArrayList<>();

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartAdapter.CartViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        holder.tvImage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.product_icon, 0, 0, 0);
        Product product = productRepo.findById(productStatusList.get(position).getProductId());
        holder.tvProductName.setText(product.getName());
        holder.tvQuantityValue.setText(productStatusList.get(position).getQuantity().toString());
        holder.tvPriceValue.setText("$ " + productStatusList.get(position).getQuantity() * product.getPrice());
        if (productStatusSelectedIds.contains(productStatusList.get(position).getId().toString())) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkBox.isChecked()) {
                    productStatusSelectedIds.add(productStatusList.get(position).getId().toString());
                    totalPrice += productStatusList.get(position).getQuantity() * product.getPrice();
                    checkboxCheckedIds.add(holder.checkBox);
                } else {
                    productStatusSelectedIds.remove(productStatusList.get(position).getId().toString());
                    totalPrice -= productStatusList.get(position).getQuantity() * product.getPrice();
                    checkboxCheckedIds.remove(holder.checkBox);
                }
                if (productStatusSelectedIds.size() == productStatusList.size()) {
                    isSelectedAll = true;
                } else {
                    isSelectedAll = false;
                }
                myCartListener.onCheckboxSelectedListener(productStatusSelectedIds, isSelectedAll, totalPrice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productStatusList.size();
    }

    public List<String> selectedAll(List<String> ids, Long totalPrice) {
        this.totalPrice = totalPrice;
        isSelectedAll = true;
        productStatusSelectedIds.clear();
        productStatusSelectedIds.addAll(ids);
        notifyDataSetChanged();
        return productStatusSelectedIds;
    }

    public void unselectedAll() {
        this.totalPrice = 0L;
        isSelectedAll = false;
        productStatusSelectedIds.clear();
        notifyDataSetChanged();
    }

    protected class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CheckBox checkBox;
        private TextView tvImage;
        private TextView tvProductName;
        private TextView tvQuantityValue;
        private TextView tvPriceValue;
        private CartAdapter adapter;
        public CartViewHolder(@NonNull View itemView, CartAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.checkBox = itemView.findViewById(R.id.checkBox);
            this.tvImage = itemView.findViewById(R.id.image_icon);
            this.tvProductName = itemView.findViewById(R.id.tv_product_name);
            this.tvQuantityValue = itemView.findViewById(R.id.tv_quantity_value);
            this.tvPriceValue = itemView.findViewById(R.id.tv_price_value);
        }


        @Override
        public void onClick(View v) {
        }
    }
}
