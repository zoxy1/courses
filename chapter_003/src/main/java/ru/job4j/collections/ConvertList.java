package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                integerList.add(array[i][j]);
            }
        }
        return integerList;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int cols = list.size() / rows;
        if (list.size() % rows != 0) {
            cols++;
        }
        int array[][] = new int[cols][rows];
        int indexList = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (indexList > list.size() - 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(indexList);
                }
                indexList++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> listInteger = new ArrayList<>();
        for (int[] mass : list) {
            for (int i = 0; i < mass.length; i++) {
                listInteger.add(mass[i]);
            }
        }
        return listInteger;
    }
}
