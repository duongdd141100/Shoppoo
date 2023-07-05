package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.Shop;

@Database(entities = Shop.class, version = 1)
@TypeConverters({Converters.class})
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    public static UserRoomDatabase INSTANCE = null;

    public static UserRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                UserRoomDatabase.class, Constant.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
