package binarySearch;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 * 二分查找
 * 前提是数据结构必须先排好序，可以在对数时间复杂度内完成查找 。
 * 二分查找也是一种分治策略,它利用了元素间的次序,可在最坏的情况下O（logN)完成搜索任务
 * 基本思想 ：
 * 假设数组元素呈 升 序 排 列， 将 n 个 元素 分成个数大 致 相同 的两 半 ， 取 a[n/2] 与 欲 查找 的 x 作比 较 ， 如果 x=a[n/2] 则找 到 x ， 算法 终止 ； 如 果 x<a[n/2] ， 则 我们 只 要在数组 a 的 左半 部 继 续 搜索 x ； 如果 x>a[n/2] ， 则 我们 只 要在数组 a 的 右 半 部 继 续 搜索 x 。
 * 适用于不经常变化
 */
public class BinarySearch {
    /**
     * 基本用法
     *
     * @param a
     * @param key
     * @return
     */
    public static int binarySearch(int[] a, int key) {
        //定义出事查找范围 双指针
        int left = 0;
        int right = a.length - 1;

        //排除特殊情况
        if (key < a[left] && key > a[right]) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] < key) {
                //取右半部分
                left = mid + 1;
            } else if (a[mid] > key) {
                //取左半部分
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找之递归算法
     *
     * @param a
     * @param key
     * @param fromIndex
     * @param endIndex
     * @return
     */
    public static int binarySearch02(int[] a, int key, int fromIndex, int endIndex) {
        //1、基本判断，当起始位置大于结束位置时，直接范围-1，特殊情况超过最大最小值，直接返回-1
        if (key < a[fromIndex] || key > a[endIndex] || fromIndex > endIndex) {
            return -1;
        }
        int mid = (fromIndex + endIndex) / 2;
        //判断中间位置元素和key大小的关系,递归操作
        if (a[mid] < key) {
            fromIndex = mid + 1;
            return binarySearch02(a, key, fromIndex, endIndex);
        } else if (a[mid] > key) {
            endIndex = mid - 1;
            return binarySearch02(a, key, fromIndex, endIndex);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 1, 43, 67, 134, 78, 123};
        int key = 43;
        int i = binarySearch(arr, key);
        int i1 = binarySearch02(arr, key, 0, arr.length - 1);
        System.out.println(i);
    }
}
