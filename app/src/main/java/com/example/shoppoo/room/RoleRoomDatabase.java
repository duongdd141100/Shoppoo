package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.RoleDAO;
import com.example.shoppoo.entity.Role;

@Database(entities = Role.class, version = 1)
@TypeConverters({Converters.class})
public abstract class RoleRoomDatabase extends RoomDatabase {

    public abstract RoleDAO roleDAO();

    public static RoleRoomDatabase INSTANCE = null;

    public static RoleRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                RoleRoomDatabase.class, Constant.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
