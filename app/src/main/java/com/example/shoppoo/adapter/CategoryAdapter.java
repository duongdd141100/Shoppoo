package com.example.shoppoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    public CategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    private List<Category> categories;

    private Context context;
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.textViewCategory.setText(categories.get(position).getName());
        holder.textViewCategory.setCompoundDrawablesWithIntrinsicBounds(R.drawable.category_icon, 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    protected class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewCategory;
        private CategoryAdapter adapter;
        public CategoryViewHolder(@NonNull View itemView, CategoryAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.textViewCategory = itemView.findViewById(R.id.textview_category);
        }


        @Override
        public void onClick(View v) {
        }
    }
}
