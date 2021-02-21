package array;


public class arrayMain {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person(10,"张三"));
        arrayList.add(null);
        arrayList.add(new Person(11,"李四"));
        arrayList.add(new Person(12,"王五"));
        arrayList.add(new Person(13,"赵六"));
        arrayList.add(new Person(14,"张一"));
        arrayList.add(new Person(15,"张二"));
        System.out.println(arrayList);
        arrayList.indexOf(null);
        System.out.println(arrayList);
        Assert.test(arrayList.size()==3);
        Assert.test(arrayList.size()==7);
       /* int size = arrayList.size();
        System.out.println("数组的元素:" + size);*/
      /*  int i = arrayList.get(1);
        System.out.println("获取1位置的元素:"+i);
        int set = arrayList.set(1, 22);
        System.out.println("替换原来位置的元素:
        "+set);*/
      /*  arrayList.add(100);
        arrayList.add(101);
        arrayList.add(102);
        arrayList.add(103);
        arrayList.add(104);
        arrayList.add(105);
        arrayList.add(106);*/
      /*  System.out.println(arrayList);
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.add(arrayList.size()-1, 1011);
        System.out.println(arrayList);*/
       /* Assert.test(arrayList.get(3) == 1011);*/
    }
}
