/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/20
 * <p>
 * 归并排序
 * 归并排序= 递归+合并，主要是分治算法
 */
public class MergeSort {


    public static void main(String[] args) {

    }


    /**
     * 递归方法的实现
     *
     * @param array
     */
    public static void mergeSort01(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process(array, 0, array.length - 1);

    }

    /**
     * arr[L-----R]范围上，变成有序的
     *
     * @param array
     * @param l
     * @param r
     */
    private static void process(int[] array, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(array, l, mid);
        process(array, mid + 1, r);
        merge(array, l, mid, r);
    }

    private static void merge(int[] array, int l, int mid, int r) {

        //定义辅助数组
        int[] help = new int[r - l + 1];

        int i = 0;

        int p1 = l;
        int p2 = mid + 1;
        //p1和p2下标都不越界的情况下
        while (p1 <= mid && p2 <= r) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }

        //下面两种情况只会出现一种，要么就是p1越界，要么就是p2越界
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }

        while (p2 <= r) {
            help[i++] = array[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            array[l + i] = help[i];
        }
    }

    /**
     * 非递归
     *
     * @param array
     */
    public static void mergeSort02(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        int mergeSize = 1;
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int mid = l + mergeSize - 1;
                if (mid >= n) {
                    break;
                }
                int r = Math.min(mid + mergeSize, n - 1);
                merge(array, l, mid, r);
                l = r + 1;
            }
            //防止边界溢出
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * 常见练习题
     * 求数组小和
     * 问题：
     * 数组小和定义：
     * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加，叫数组小和。
     * 例子：数组 [1,3,4,2,5]
     * 1 左边比 1 小的数：没有
     * 3 左边比 3 小的数：1
     * 4 左边比 4 小的数：1、3
     * 2 左边比 2 小的数：1
     * 5 左边比 5 小的数：1、3 、4 、2
     * 所以数组的小和为：1+1+3+1+1+3+4+2=16
     * 在归并排序的过程中，merge的时候，左组的数比右组的数小的时候产生小和，其余时候不产生小和。
     * 对于每个数来说，右边有多少个数比当前数大，当前数产生多少个小和。
     *
     */
    public static void  test(){

    }
}
