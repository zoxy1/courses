package ru.job4j.collections.sort;

import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result;
        if (left.size() < right.size()) {
            result = -1;
        } else {
            result = 1;
        }
        if (left.size() == right.size()) {
            result = 0;
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) != right.get(i)) {
                    if (left.get(i) < right.get(i)) {
                        result = -1;
                    } else {
                        result = 1;
                    }
                    break;
                }
            }
        }
        return result;
    }
}

