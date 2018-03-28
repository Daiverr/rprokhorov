package ru.job4j.sort;

import java.util.Comparator;
import java.lang.Character;

public class ListCompare implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int length = Integer.compare(o1.length(), o2.length());
        String buffer = o1;
        if (length == 1) {
            buffer = o2;
        }
        for (int i = 0; i < buffer.length(); i++) {
           if (Character.compare(o1.charAt(i), o2.charAt(i)) > 1) {
               result = 1;
               break;
           } else if (Character.compare(o1.charAt(i), o2.charAt(i)) < 0) {
               result = (-1);
               break;
           }
        }
        if (result == 0 & length != 0) {
            result = length;
        }
        return result;
    }

}

/*
В это задании нужно создать подобный метод самому.

Вам нужно реализовать компаратор для сравнения двух массивов символов.

Необходимо реализовать поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков, находящихся на одних и тех же позициях (по одним и тем же индексом). Сравнение в лексикографическом порядке.

В этом задании нельзя использовать метод String.compateTo.

Вы можете использовать

String.charAt(int index)

Integer.compare(int left, int right),

Character.compare(char left, char right);
 */