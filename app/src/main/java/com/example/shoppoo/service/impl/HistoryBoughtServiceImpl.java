package com.example.shoppoo.service.impl;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppoo.adapter.HistoryBoughtAdapter;
import com.example.shoppoo.common.ProductStatusEnum;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.ProductStatusRepository;
import com.example.shoppoo.service.HistoryBoughtService;

import java.util.List;

public class HistoryBoughtServiceImpl implements HistoryBoughtService {

    private Context context;

    private User user;

    private RecyclerView recyclerViewHistoryBought;

    private ProductStatusRepository productStatusRepo;

    public HistoryBoughtServiceImpl(Context context, RecyclerView recyclerViewHistoryBought, User user) {
        this.context = context;
        this.user = user;
        this.recyclerViewHistoryBought = recyclerViewHistoryBought;
        productStatusRepo = new ProductStatusRepository(this.context);
    }

    @Override
    public void setProductHistoryRecycleView() {
        List<ProductStatus> productStatusList = productStatusRepo.findByUsernameAnStatus(user.getUsername(), ProductStatusEnum.BOUGHT.getKey());
        RecyclerView.LayoutManager layoutManagerVertical = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewHistoryBought.setLayoutManager(layoutManagerVertical);
        HistoryBoughtAdapter adapter = new HistoryBoughtAdapter(productStatusList, context);
        recyclerViewHistoryBought.setAdapter(adapter);
    }
}
