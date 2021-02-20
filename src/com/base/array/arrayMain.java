package com.base.array;


public class arrayMain {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        int size = arrayList.size();
        System.out.println("数组的元素:" + size);
      /*  int i = arrayList.get(1);
        System.out.println("获取1位置的元素:"+i);
        int set = arrayList.set(1, 22);
        System.out.println("替换原来位置的元素:
        "+set);*/
        arrayList.add(100);
        arrayList.add(101);
        arrayList.add(102);
        arrayList.add(103);
        arrayList.add(104);
        arrayList.add(105);
        arrayList.add(106);
      /*  System.out.println(arrayList);
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.add(arrayList.size()-1, 1011);
        System.out.println(arrayList);*/
       /* Assert.test(arrayList.get(3) == 1011);*/
    }
}
