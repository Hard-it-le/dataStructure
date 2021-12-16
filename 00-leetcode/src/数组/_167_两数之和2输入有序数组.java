package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/16
 */
public class _167_两数之和2输入有序数组 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4,};
        int target = 6;
        _167_两数之和2输入有序数组 test = new _167_两数之和2输入有序数组();
        int[] ints = test.twoSum03(array, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    /**
     * 方法一：双重循环，暴力破解
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum01(int[] numbers, int target) {

        int n = numbers.length;
        //双重循环判断
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    if (i == j && numbers[i] == numbers[j]) {
                        continue;
                    }
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 方法二：双指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum02(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 方法三：二分查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum03(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (numbers[mid] + numbers[i] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] + numbers[i] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 方法四：使用哈希表特性进行解决
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum04(int[] numbers, int target) {
        int n = numbers.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = target - numbers[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }


}
