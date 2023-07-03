package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.ProductDAO;
import com.example.shoppoo.entity.Product;

@Database(entities = Product.class, version = 1)
@TypeConverters({Converters.class})
public abstract class ProductRoomDatabase extends  RoomDatabase {

    public abstract ProductDAO productDAO();

    public static ProductRoomDatabase INSTANCE = null;

    public static ProductRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                ProductRoomDatabase.class, "ProductDatabase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
