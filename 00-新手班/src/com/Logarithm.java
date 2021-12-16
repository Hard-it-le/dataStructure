package com;

import java.util.Random;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/16
 * <p>
 * 对数器
 */
public class Logarithm {
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] array = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (((maxValue + 1) * Math.random()) - (maxValue * Math.random()));

        }
        return array;
    }

}
