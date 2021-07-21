import file.Files;
import printer.BinaryTrees;

import java.util.Comparator;

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

    static void test1() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1,10
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
       // bst.preorderTraversal();
       // bst.inorderTraversal();
        //bst.postorderTraversal();
        bst.levelOrderTraversal();
    }

    static void test2() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3,12,1
        };
        BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new PersonComparator());
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }
        BinaryTrees.println(bst1);
    }

    static void test3() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BinarySearchTree<Person> bst3 = new BinarySearchTree<>(new PersonComparator2());
        for (int i = 0; i < data.length; i++) {
            bst3.add(new Person(data[i]));
        }
        BinaryTrees.println(bst3);
    }

    static void test4() {
        BinarySearchTree<Integer> bst4 = new BinarySearchTree<>();
        for (int i = 0; i < 30; i++) {
            bst4.add((int) (Math.random() * 100));
        }
        String s = BinaryTrees.printString(bst4);
        Files.writeToFile("",s);
    }


    public static void main(String[] args) {
        test1();
    }
}
