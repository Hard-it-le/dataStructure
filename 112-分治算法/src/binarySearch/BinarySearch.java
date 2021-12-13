package binarySearch;

import javax.swing.text.html.HTMLWriter;
import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 * 二分查找
 * 前提是数据结构必须先排好序，
 * 可以在对数时间复杂度内完成查找 。
 * 二分查找也是一种分治策略,它利用了元素间的次序,可在最坏的情况下O（logN)完成搜索任务
 * 基本思想 ：
 * 假设数组元素呈升序排列，将n个元素分成个数大致相同的两半 ，取a[n/2]与欲查找的x作较 ，
 * 如果x=a[n/2]则找到x ，算法终止；如果x<a[n/2] ，
 * 则我们只要在数组a的左半部继续搜索x ；
 * 如果 x>a[n/2]则我们只要在数组a的右半部继续搜索x 。
 * <p>
 * <p>
 * 适用于不经常变化
 */
public class BinarySearch {


    public static void main(String[] args) {
        logarithm();
    }

    /**
     * 对数器开始
     */
    public static void logarithm() {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (logarithmTest(arr, value) != binarySearch03(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static boolean logarithmTest(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    /**
     * 问题：有序数组中找到num
     * <p>
     * 二分法
     *
     * @param array
     * @param num
     * @return
     */
    public static boolean binarySearch03(int[] array, int num) {
        if (array == null || array.length == 0) {
            return false;
        }
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] == num) {
                return true;
            } else if (array[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }


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


    /**
     * 问题：有序数组中找到>=num最左的位置
     * 前提：array有序
     *
     * @param array
     * @param num
     * @return
     */
    public static int mostLeftNoMoreNumIndex(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 问题：有序数组中找到<=num最右的位置
     * <p>
     * 前提：array有序,>=num的最右的位置
     *
     * @param array
     * @param num
     * @return
     */
    public static int mostRightNoMoreNumIndex(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int n = array.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] <= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


    /**
     * 局部最小值
     * <p>
     * 前提：arr整体无序
     * arr 相邻之间的数不相等
     *
     * @param array
     * @return
     */
    public static int onMinIndex(int[] array) {
        int n = array.length;
        if (array == null || n == 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        if (array[0] < array[1]) {
            return 0;
        }
        if (array[n - 1] < array[n - 2]) {
            return n - 1;
        }

        int l = 0;
        int r = n - 1;

        /**
         * 特殊例子
         *
         * 3 2 3 2 3
         * 0 1 2 3 4
         *
         * l = 0 ，r = 3
         *
         * mid = 2；
         * arr【mid】=3
         *
         * 右边划掉
         *
         * 3 2
         * 0 1
         *
         * l = 0，r =1；
         *
         *  mid = 0
         *
         *  mid - 1 = -1 则报错
         *
         *  mid + 1 =1 ，正常
         *
         *  如果数组长度》=3时，才能这
         */
        while (l < (r - 1)) {
            int mid = (l + r) / 2;
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            } else {
                // 1、左 》 我   我 》 右

                // 2、左《 我   我《 右

                // 3、左《 我  我 》右
                if (array[mid] > array[mid - 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            }


//            if (array[mid] > array[mid + 1]) {
//                l = mid + 1;
//                continue;
//            }
        }

        return array[l] < array[r] ? l : r;
    }

}
