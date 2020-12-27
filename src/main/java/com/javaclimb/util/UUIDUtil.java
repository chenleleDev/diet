package com.javaclimb.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtil {

    public static String getUUID() {
        String str = UUID.randomUUID().toString();
        str = str.replace("-", "");
        return str;
    }

    public static String getOrderSn() {
        return System.currentTimeMillis()
                + String.format("%07d", new Random().nextInt(1000000));
    }
}
