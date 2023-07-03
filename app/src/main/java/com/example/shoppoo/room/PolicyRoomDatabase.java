package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.PolicyDAO;
import com.example.shoppoo.entity.Policy;

@Database(entities = {Policy.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class PolicyRoomDatabase extends RoleRoomDatabase {

    public abstract PolicyDAO policyDAO();

    private static PolicyRoomDatabase INSTANCE = null;

    public static PolicyRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                PolicyRoomDatabase.class, "PolicyDatabase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
