package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.ProductStatusDAO;
import com.example.shoppoo.entity.ProductStatus;

@Database(entities = ProductStatus.class, version = 1)
@TypeConverters({Converters.class})
public abstract class ProductStatusRoomDatabase extends RoomDatabase {

    public abstract ProductStatusDAO productStatusDAO();

    public static ProductStatusRoomDatabase INSTANCE = null;

    public static ProductStatusRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                ProductStatusRoomDatabase.class, "ProductStatusDatabase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
