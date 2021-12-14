import utils.Integers;
import utils.Times;
import utils.Utils;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/14
 * <p>
 * 冒泡排序:每次交换都是相邻对比
 * <p>
 * 当前数比前一位数字小就交换
 * <p>
 * 冒泡排序最好时间复杂度 o（n）
 * 平均时间复杂度和最坏时间复杂度是o（n^2）
 * <p>
 * <p>
 * 原地算法：不依赖额外的资源或者极少数额外的资源，仅依靠输出来覆盖输入
 * <p>
 * 空间复杂度为O（1）都可以认为是原地算法
 */
public class BubbleSort extends Utils {

    public static void main(String[] args) {

        Integer[] random1 = Integers.tailAscOrder(10, 10000, 7000);
        Integer[] random2 = Integers.copy(random1);
        Integer[] random3 = Integers.copy(random1);
        Times.test("bubbleSort01", () -> {
            bubbleSort01(random1);
        });
        Times.test("bubbleSort02", () -> {
            bubbleSort02(random2);
        });
        Times.test("bubbleSort03", () -> {
            bubbleSort03(random3);
        });
    }

    /**
     * 方法一 暴力循环双重for循环
     * <p>
     * 最基础的方法
     *
     * @param array
     */
    public static void bubbleSort01(Integer[] array) {
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

    /**
     * 冒泡优化一
     * <p>
     * <p>
     * 数组前面或者按升序排列，则进行第一次循环比较进行标记
     *
     * @param array
     */
    public static void bubbleSort02(Integer[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length - 1;
        for (int end = n; end >= 0; end--) {
            boolean isSorted = true;
            for (int second = 1; second <= end; second++) {
                if (array[second - 1] > array[second]) {
                    swap(array, second - 1, second);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化二
     * <p>
     * 如果尾部有序，可以记录最后一次交换的位置，减少比较次数
     *
     * @param array
     */
    public static void bubbleSort03(Integer[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length - 1;
        for (int end = n; end > 0; end--) {
            //sortedIndex的初始化在数组完全有序的时候游泳
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin - 1] > array[begin]) {
                    swap(array, begin - 1, begin);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
