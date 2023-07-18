package com.example.shoppoo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.shoppoo.entity.CategoryProduct;

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;
    private final ListView listView;

    public OnSwipeTouchListener(Context context, ListView listView) {
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.listView = listView;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            int position = listView.pointToPosition((int) e.getX(), (int) e.getY());
            CategoryProduct selectedCategory = (CategoryProduct) listView.getItemAtPosition(position);
            ((CategoryListActivity) listView.getContext()).editCategoryProduct(selectedCategory);
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffX = e2.getX() - e1.getX();
                float diffY = e2.getY() - e1.getY();
                if (Math.abs(diffX) > Math.abs(diffY) && Math.abs(diffX) > SWIPE_THRESHOLD &&
                        Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX < 0) {
                        int position = listView.pointToPosition((int) e1.getX(), (int) e1.getY());
                        CategoryProduct selectedCategory = (CategoryProduct) listView.getItemAtPosition(position);
                        ((CategoryListActivity) listView.getContext()).deleteCategoryProduct(selectedCategory);
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}
