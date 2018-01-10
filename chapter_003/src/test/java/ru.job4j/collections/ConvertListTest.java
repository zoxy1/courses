package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTest {
    @Test
    public void convertArrayToList() {
        ConvertList convertList = new ConvertList();
        int array[][] = {{1, 2, 3}, {4, 5, 6}, {7}};
        List<Integer> list = convertList.toList(array);
        for (Integer value : list) {
            System.out.printf(String.valueOf(value.intValue()) + ", ");
        }
    }

    @Test
    public void convertListToArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int array[][] = convertList.toArray(list, 4);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void convertListArraysToList() {
        ConvertList convertList = new ConvertList();
        List<int[]> listArrays = Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(listArrays);
        for (Integer value : result) {
            System.out.print(value + " ");
        }
    }
}
