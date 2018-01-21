package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class PerformanceCollectionsTest {
    @Test
    public void performanceAddRandomToArrayList() {
        int amount = 100000;
        int amountDelete = amount / 4;
        PerformanceCollections performanceCollections = new PerformanceCollections();
        long timeAddLinkedList = performanceCollections.add(new LinkedList<>(), amount);
        System.out.println(String.format("Время выполнения вставки %s элементов для LinkedList:%s", amount, timeAddLinkedList));

        long timeDeleteLinkedList = performanceCollections.delete(performanceCollections.getCollection(), amountDelete);
        System.out.println(String.format("Время удаления первых %s элементов из LinkedList:%s", amountDelete, timeDeleteLinkedList));

        long timeAddArrayList = performanceCollections.add(new ArrayList<>(), amount);
        System.out.println(String.format("Время выполнения вставки %s элементов для ArrayList:%s", amount, timeAddArrayList));

        long timeDeleteArrayList = performanceCollections.delete(performanceCollections.getCollection(), amountDelete);
        System.out.println(String.format("Время удаления первых %s элементов из ArrayList:%s", amountDelete, timeDeleteArrayList));

        long timeTreeSet = performanceCollections.add(new TreeSet<>(), amount);
        System.out.println(String.format("Время выполнения вставки %s элементов для TreeSet:%s", amount, timeTreeSet));

        long timeDeleteTreeSet = performanceCollections.delete(performanceCollections.getCollection(), amountDelete);
        System.out.println(String.format("Время удаления первых %s элементов из TreeSet:%s", amountDelete, timeDeleteTreeSet));
    }
}
