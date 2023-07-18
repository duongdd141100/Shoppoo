package com.example.shoppoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.R;
import com.example.shoppoo.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    private List<User> users;

    private Context context;
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.tvUsername.setText(users.get(position).getUsername());
        holder.tvFullname.setText(users.get(position).getFullname());
        holder.tvGender.setText(users.get(position).getGender().toString());
        holder.tvAddress.setText(users.get(position).getAddress());
        holder.tvPhone_number.setText(users.get(position).getPhoneNumber().toString());
        holder.tvEmail.setText(users.get(position).getEmail());
        holder.tvRole.setText(users.get(position).getRole());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    protected class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvUsername;
        private TextView tvFullname;
        private TextView tvGender;
        private TextView tvAddress;
        private TextView tvPhone_number;
        private TextView tvEmail;
        private TextView tvRole;
        private UserAdapter adapter;
        public UserViewHolder(@NonNull View itemView, UserAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            this.tvUsername = itemView.findViewById(R.id.tv_username);
            this.tvGender = itemView.findViewById(R.id.tv_gender);
            this.tvFullname = itemView.findViewById(R.id.tv_fullname);
            this.tvAddress = itemView.findViewById(R.id.tv_address);
            this.tvPhone_number = itemView.findViewById(R.id.tv_phone_number);
            this.tvEmail = itemView.findViewById(R.id.tv_email);
            this.tvRole = itemView.findViewById(R.id.tv_role);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
