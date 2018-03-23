package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void convertToList() {
        ConvertList convert = new ConvertList();
        List<Integer> result = convert.toList(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0 ,0}});
        assertThat(result.get(3), is(4));
    }

    @Test
    public void convertToArray() {
        ConvertList convert = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        int[][] result = convert.toArray(list, 3);
              //  {{1, 2, 3}, {4, 5, 6}, {7, 0 ,0}}
        assertThat(result[2][2], is(0));
    }
}
