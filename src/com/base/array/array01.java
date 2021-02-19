package com.base.array;

public class array01 {
    public static void main(String[] args) throws IllegalAccessException {
        array02 arr = new array02(20);
        boolean contains = arr.contains(0);
        System.out.println(contains);
        int findIndex = arr.findIndex(0);
        System.out.println(findIndex);
        int deleteArray = arr.deleteArray(1);
        System.out.println(deleteArray);
    }
}
