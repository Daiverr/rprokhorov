package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman Prokhorov (daiverr1@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertList {
    public List<Integer> toList (int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[i].length; k++) {
                result.add(array[i][k]);
            }
        }
        return result;
    }

    public int[][] toArray (List<Integer> list, int rows) {
        int column = list.size()/rows;
        if (list.size() % rows != 0) {
            column++;
        }
        int[][] result = new int[rows][column];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < column; k++) {
                if (iterator.hasNext()) {
                    result[i][k] = iterator.next();
                } else result[i][k] = 0;
            }
        }

        return result;
    }

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ms: list) {
            for (int nm: ms) {
                result.add(nm);
            }
        }
        return result;
    }
}
