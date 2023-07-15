package com.example.shoppoo.adapter;

import java.util.List;

public interface MyCartListener {
    void onCheckboxSelectedListener(List<String> productStatusIds, Boolean isSelectedAll, Long totalPrice);
}
