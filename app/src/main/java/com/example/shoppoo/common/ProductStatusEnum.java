package com.example.shoppoo.common;

public enum ProductStatusEnum {
    IN_CART("IN_CART", "In Cart"),
    CONFIRMING("CONFIRMING", "Confirming"),
    BOUGHT("BOUGHT", "Bought");

    private String key;

    private String value;

    ProductStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ProductStatusEnum typeOf(String key) {
        for (ProductStatusEnum status : ProductStatusEnum.values()) {
            if (status.key.equals(key)) {
                return status;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
