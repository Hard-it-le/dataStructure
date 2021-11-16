/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/14
 * 冒泡排序
 */
class BubbleSort {

    /**
     * 方法一 暴力循环双重for循环
     * @param array
     */
    public static void bubbleSort01(int[] array) {
        int length = array.length;

        for (int j = length - 1; j > 0; j--) {
            for (int i = 1; i <= j; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }


        for (int i : array) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {

        int[] array = {10, 6, 9, 12, 45, 67, 14, 32};
        bubbleSort01(array);
    }
}
