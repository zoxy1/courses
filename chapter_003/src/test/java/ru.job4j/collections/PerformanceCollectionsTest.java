package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class PerformanceCollectionsTest {
    @Test
    public void performanceAddRandomToArrayList () {
        int amount = 3000;
        PerformanceCollections performanceCollections = new PerformanceCollections();
        long timeRemoveLinkedList = performanceCollections.add(new LinkedList<>(), amount);
        System.out.println(String.format("Время выволнения вставки %s элементов для LinkedList:%s", amount, timeRemoveLinkedList));
        long timeDeleteLinkedList = performanceCollections.delete(performanceCollections.collection, amount/10);
        System.out.println(String.format("Время удаления %s элементов из LinkedList:%s", amount/10, timeDeleteLinkedList));

        long timeArrayList = performanceCollections.add(new ArrayList<>(), amount);
        System.out.println(String.format("Время выволнения вставки %s элементов для ArrayList:%s", amount, timeArrayList));
        long timeTreeSet = performanceCollections.add(new TreeSet<>(), amount);
        System.out.println(String.format("Время выволнения вставки %s элементов для TreeSet:%s", amount, timeTreeSet));



    }
}
