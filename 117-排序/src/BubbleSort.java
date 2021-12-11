/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/14
 *
 * 冒泡排序:每次交换都是相邻对比
 *
 *
 * 当前数比前一位数字小就交换
 */
public class BubbleSort extends Utils {

    public static void main(String[] args) {

        int[] array = {10, 6, 9, 12, 45, 67, 14, 32};
        printArray(array);
        bubbleSort01(array);
        printArray(array);
    }

    /**
     * 方法一 暴力循环双重for循环
     *
     * @param array
     */
    public static void bubbleSort01(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;

        for (int end = n - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (array[second - 1] > array[second]) {
                    swap(array, second - 1, second);
                }
            }
        }
    }


}
