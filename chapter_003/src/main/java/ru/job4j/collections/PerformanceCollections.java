package ru.job4j.collections;

import java.util.*;

public class PerformanceCollections {
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int STR_LENGTH = 5; // длина генерируемой строки
    Collection<String> collection;
    Random random = new Random();

    public long add(Collection<String> collection, int amount) {

        Date startLinked = new Date();
        for (int i = 0; i < amount; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < STR_LENGTH; j++) {
                int number = random.nextInt(mCHAR.length());
                char ch = mCHAR.charAt(number);
                builder.append(ch);
            }
            collection.add(builder.toString());
        }
        this.collection = collection;
        Date finishLinked = new Date();
        return finishLinked.getTime() - startLinked.getTime();
    }

    public long delete(Collection<String> collection, int amount) {
        Date startLinked = new Date();

    Iterator<String> iter = collection.iterator();

        Date finishLinked = new Date();
        return finishLinked.getTime() - startLinked.getTime();
    }
}
