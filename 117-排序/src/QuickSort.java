/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/21
 * <p>
 * 快速排序
 */
public class QuickSort {

    /**
     * 快速排序实现一
     *
     * @param arr
     */
    public static void quickSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process01(arr, 0, arr.length - 1);
    }

    private static void process01(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process01(arr, l, m - 1);
        process01(arr, m + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        return -1;
    }


    /**
     * 快速排序实现二
     *
     * @param arr
     */
    public static void quickSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process02(arr, 0, arr.length - 1);
    }

    private static void process02(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, l, r);
        process01(arr, l, equalArea[0] - 1);
        process01(arr, equalArea[1] + 1, r);
    }

    private static int[] netherlandsFlag(int[] arr, int l, int r) {
        return new int[]{l + 1, r};
    }

}
