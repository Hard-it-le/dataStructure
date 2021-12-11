/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/10
 */
public class Utils {


    /**
     * 交换两个数字之间的位置
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
