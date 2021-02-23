package array;


/**
 * 动态数组
 * 优点:
 * 1.可以按照索引查询元素,速度很快
 * 2.能够存储大量数据
 * 3.按照索引遍历数组很方便
 * 4.数组定义简单,方便访问
 * 5.可以随机访问其中的元素
 * 缺点:1.可能会造成空间的大量浪费
 * 2.无法做的申请多少个内存就用多少内存
 * 3.根据内容查找元素很慢
 * 4.
 */
public class arrayMain {

    public static void main(String[] args) {
        //java自己的动态数组
        java.util.ArrayList list = new java.util.ArrayList();
        //自己定义的动态数组
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
