package com.example.shoppoo.common;

import android.content.Context;

import com.example.shoppoo.entity.Category;
import com.example.shoppoo.entity.Policy;
import com.example.shoppoo.entity.Product;
import com.example.shoppoo.entity.ProductStatus;
import com.example.shoppoo.entity.Role;
import com.example.shoppoo.entity.Shop;
import com.example.shoppoo.entity.User;
import com.example.shoppoo.repository.CategoryRepository;
import com.example.shoppoo.repository.PolicyRepository;
import com.example.shoppoo.repository.ProductRepository;
import com.example.shoppoo.repository.ProductStatusRepository;
import com.example.shoppoo.repository.RoleRepository;
import com.example.shoppoo.repository.ShopRepository;
import com.example.shoppoo.repository.UserRepository;

import java.util.Arrays;

public class DataCommon {
    public static void initData(Context context) {
        insertCategory(context);
        insertRole(context);
        insertPolicy(context);
        insertShop(context);
        insertUser(context);
        insertProduct(context);
        insertProductStatus(context);
    }

    private static void insertProductStatus(Context context) {
        ProductStatus productStatus1 = new ProductStatus(1L, "duongdd_user", 3L, 2, ProductStatusEnum.IN_CART.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus2 = new ProductStatus(2L, "duongdd_user", 4L, 2, ProductStatusEnum.BOUGHT.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus3 = new ProductStatus(3L, "gianghv_user", 5L, 2, ProductStatusEnum.IN_CART.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus4 = new ProductStatus(4L, "gianghv_user", 6L, 2, ProductStatusEnum.BOUGHT.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus5 = new ProductStatus(5L, "conghx_user", 7L, 2, ProductStatusEnum.IN_CART.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus6 = new ProductStatus(6L, "conghx_user", 8L, 2, ProductStatusEnum.BOUGHT.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus7 = new ProductStatus(7L, "huynl_user", 1L, 2, ProductStatusEnum.IN_CART.getKey(),
                null, null, null, null, null);
        ProductStatus productStatus8 = new ProductStatus(8L, "huynl_user", 2L, 2, ProductStatusEnum.BOUGHT.getKey(),
                null, null, null, null, null);
        ProductStatusRepository productStatusRepo = new ProductStatusRepository(context);
        productStatusRepo.save(Arrays.asList(productStatus1, productStatus2, productStatus3, productStatus4,
                productStatus5, productStatus6, productStatus7, productStatus8));
    }

    private static void insertProduct(Context context) {
        Product iphone13 = new Product(1L, "Iphone 13", 20L, 20, "Iphone 13 Description",
                1L, null, null, null, null, null);
        Product iphone14 = new Product(2L, "Iphone 14", 20L, 30, "Iphone 14 Description",
                1L, null, null, null, null, null);
        Product samsungS3 = new Product(3L, "Samsung Galaxy S3", 15L, 20, "Samsung Galaxy S3 Description",
                2L, null, null, null, null, null);
        Product samsungs4 = new Product(4L, "Samsung Galaxy S4", 25L, 20, "Samsung Galaxy S4 Description",
                2L, null, null, null, null, null);
        Product astrox77 = new Product(5L, "Astrox 77", 19L, 20, "Astrox 77 Description",
                3L, null, null, null, null, null);
        Product astrox88 = new Product(6L, "Astrox 88", 25L, 20, "Astrox 88 Description",
                3L, null, null, null, null, null);
        Product kohaRed = new Product(7L, "Koha Red", 22L, 20, "Koha Red Description",
                4L, null, null, null, null, null);
        Product kohaLavy = new Product(8L, "Koha Lavy", 24L, 20, "Koha Lavy Description",
                4L, null, null, null, null, null);
        ProductRepository productRepo = new ProductRepository(context);
        productRepo.save(Arrays.asList(iphone13, iphone14, samsungS3, samsungs4, astrox77, astrox88, kohaRed, kohaLavy));
    }

    private static void insertUser(Context context) {
        User duongddAdmin = new User(1L, "duongdd_admin", "Do Duc Duong", true, "HN", "0912345678",
                "duongdd@gmail.com","1414", "1", null, null, null, null, null);
        User gianghvAdmin = new User(2L, "gianghv_admin", "Ha Viet Giang", true, "HN", "0912345678",
                "gianghv@gmail.com","1414", "1", null, null, null, null, null);
        User conghxAdmin = new User(3L, "conghx_admin", "Hoang Xuan Cong", true, "HN", "0912345678",
                "conghx@gmail.com","1414", "1", null, null, null, null, null);
        User huynlAdmin = new User(4L, "huynl_admin", "Nguyen Le Huy", true, "HN", "0912345678",
                "huynl@gmail.com","1414", "1", null, null, null, null, null);
        User duongddBuyerSeller = new User(5L, "duongdd_user", "Do Duc Duong", true, "HN", "0912345678",
                "duongdd@gmail.com","1414", "2;3", null, null, null, null, null);
        User gianghvBuyerSeller = new User(6L, "gianghv_user", "Ha Viet Giang", true, "HN", "0912345678",
                "gianghv@gmail.com","1414", "2;3", null, null, null, null, null);
        User conghxBuyerSeller = new User(7L, "conghx_user", "Hoang Xuan Cong", true, "HN", "0912345678",
                "conghx@gmail.com","1414", "2;3", null, null, null, null, null);
        User huynlBuyerSeller = new User(8L, "huynl_user", "Nguyen Le Huy", true, "HN", "0912345678",
                "huynl@gmail.com","1414", "2;3", null, null, null, null, null);
        UserRepository userRepo = new UserRepository(context);
        userRepo.save(Arrays.asList(duongddAdmin, gianghvAdmin, conghxAdmin, huynlAdmin, duongddBuyerSeller, gianghvBuyerSeller, conghxBuyerSeller, huynlBuyerSeller));
    }

    private static void insertShop(Context context) {
        Shop duongddShop = new Shop(1L, "DuongDD Shop", "duongdd_user", 1L, "HN",
                2, "DuongDD Shop Description", null, null, null, null, null);
        Shop gianghvShop = new Shop(2L, "GiangHV Shop", "gianghv_user", 2L, "HN",
                2, "GiangHV Shop Description", null, null, null, null, null);
        Shop conghxShop = new Shop(3L, "CongHX Shop", "conghx_user", 3L, "HN",
                2, "CongHX Shop Description", null, null, null, null, null);
        Shop huynlShop = new Shop(4L, "HuyNL Shop", "huynl_user", 4L, "HN",
                2, "HuyNL Shop Description", null, null, null, null, null);
        ShopRepository shopRep = new ShopRepository(context);
        shopRep.save(Arrays.asList(duongddShop, gianghvShop, conghxShop, huynlShop));
    }

    private static void insertPolicy(Context context) {
        Policy buyer = new Policy(1L, 2L, "Buyer policy description", null, null, null, null, null);
        Policy seller = new Policy(2L, 3L, "Seller policy description", null, null, null, null, null);
        PolicyRepository policyRepo = new PolicyRepository(context);
        policyRepo.save(Arrays.asList(buyer, seller));
    }

    private static void insertRole(Context context) {
        Role admin = new Role(1L, "Admin", null, null, null, null, null);
        Role buyer = new Role(2L, "Buyer", null, null, null, null, null);
        Role seller = new Role(3L, "Seller", null, null, null, null, null);
        RoleRepository roleRepo = new RoleRepository(context);
        roleRepo.save(Arrays.asList(admin, buyer, seller));
    }

    private static void insertCategory(Context context) {
        Category apple = new Category(1L, "Apple", null, null, null, null, null);
        Category samsung = new Category(2L, "Samsung", null, null, null, null, null);
        Category badminton = new Category(3L, "Badminton", null, null, null, null, null);
        Category soccer = new Category(4L, "Soccer", null, null, null, null, null);
        Category laptop = new Category(5L, "Laptop", null, null, null, null, null);
        CategoryRepository categoryRepo = new CategoryRepository(context);
        categoryRepo.save(Arrays.asList(apple, samsung, badminton, soccer, laptop));
    }
}
