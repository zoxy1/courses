package ru.job4j.collections;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class PerformanceCollections {
    private static final String RANDOM_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int STR_LENGTH = 5; // длина генерируемой строки

    private Collection<String> collection;
    private Random random = new Random();

    public long add(Collection<String> collection, int amount) {
        Date startLinked = new Date();
        for (int i = 0; i < amount; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < STR_LENGTH; j++) {
                int number = random.nextInt(RANDOM_CHAR.length());
                char ch = RANDOM_CHAR.charAt(number);
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
        for (int i = 0; i < amount; i++) {
            iter.next();
            iter.remove();
        }
        Date finishLinked = new Date();
        return finishLinked.getTime() - startLinked.getTime();
    }

    public Collection<String> getCollection() {
        return collection;
    }

}
