/**
 * @author yujiale
 * @Classname Main
 * @Description TODO
 * @Date 2021/7/19 下午9:59
 * @Created by yujiale
 */
public class Main {
    public static void main(String[] args) {

        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
    }
}
