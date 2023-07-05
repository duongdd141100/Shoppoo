package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.CategoryDAO;
import com.example.shoppoo.entity.Category;

@Database(entities = {Category.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class CategoryRoomDatabase extends RoomDatabase {

    public abstract CategoryDAO categoryDAO();

    private static CategoryRoomDatabase INSTANCE = null;

    public static CategoryRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                CategoryRoomDatabase.class, Constant.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
