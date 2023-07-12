package com.example.shoppoo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shoppoo.common.Constant;
import com.example.shoppoo.common.Converters;
import com.example.shoppoo.dao.CategoryDAO;
import com.example.shoppoo.dao.PolicyDAO;
import com.example.shoppoo.dao.ProductDAO;
import com.example.shoppoo.dao.ProductStatusDAO;
import com.example.shoppoo.dao.RoleDAO;
import com.example.shoppoo.dao.ShopDAO;
import com.example.shoppoo.dao.UserDAO;
import com.example.shoppoo.entity.Category;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;

@Database(entities = {Category.class, Policy.class, Product.class, ProductStatus.class, Role.class, Shop.class, User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ShoppooRoomDatabase extends RoomDatabase{

    public abstract CategoryDAO categoryDAO();

    public abstract PolicyDAO policyDAO();

    public abstract ProductDAO productDAO();

    public abstract ProductStatusDAO productStatusDAO();

    public abstract RoleDAO roleDAO();

    public abstract ShopDAO shopDAO();

    public abstract UserDAO userDAO();

    private static ShoppooRoomDatabase INSTANCE = null;

    public static ShoppooRoomDatabase getInstance(Context context) {
        synchronized (RoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                                ShoppooRoomDatabase.class, Constant.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
