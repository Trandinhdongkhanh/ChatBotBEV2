package com.tddk.chatbotapp.util;

import java.util.List;
import java.util.Random;

public class RandomList {
    public static <T> T random(List<T> list) {
        Random random = new Random();
        return list.isEmpty() ? null : list.get(random.nextInt(list.size()));
    }
}