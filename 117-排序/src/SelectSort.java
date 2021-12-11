/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/10
 * <p>
 * 选择排序：
 * 1、首先找到最小的元素，与数组中第一位元素进行交换
 * 2、除第一位元素之外，再从剩下未排序的数组中找到最小值，与第二位进行交换
 * 3、共N-1趟，每趟都找到未数组的最小值，放到已排序的数组后面。
 */
public class SelectSort extends Utils {


    public static void main(String[] args) {
        int[] array = {6, 1, 3, 6, 7, 82, 4, 6, 28, 9, 5, 10};
        printArray(array);
        selectSort01(array);
        printArray(array);

    }

    public static void selectSort01(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = array[j] < array[minValueIndex] ? j : minValueIndex;
            }

            swap(array, i, minValueIndex);
        }
    }


}
