package array;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(0, 1);
        arrayList.add(1, 3);
        arrayList.add(2, 5);
        arrayList.add(3, 7);
        arrayList.add(4, 12);
        arrayList.add(5, 6);
        arrayList.add(90);
        System.out.println(arrayList.toString());
        System.out.println("=============");
        System.out.println(arrayList.get(4));
        arrayList.remove(1);
        System.out.println(arrayList.toString());
        System.out.println("=============");
        System.out.println(arrayList.indexOf(6));
        arrayList.clear();
        System.out.println("=============");
        System.out.println(arrayList.toString());
    }
}
