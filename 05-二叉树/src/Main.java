/**
 * @author yujiale
 * @Classname Main
 * @Description TODO
 * @Date 2021/7/19 下午9:59
 * @Created by yujiale
 */
public class Main {
    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator2 implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args) {


        // Integer[] data = new Integer[]{
        //         7, 4, 9, 2, 5, 8, 11, 3
        // };
        // BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        // for (int i = 0; i < data.length; i++) {
        //     bst.add(data[i]);
        // }

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>();
        bst2.add(new Person(12));
        bst2.add(new Person(15));

        BinarySearchTree<Person> bst3 = new BinarySearchTree<>();
        bst2.add(new Person(12));
        bst2.add(new Person(15));
    }
}
