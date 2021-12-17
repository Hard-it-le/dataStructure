package 数组;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/16
 */
//符合下列属性的数组 arr 称为 山脉数组 ：
//
// arr.length >= 3
// 存在 i（0 < i < arr.length - 1）使得：
//
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//
//
//
//
// 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i +
//1] > ... > arr[arr.length - 1] 的下标 i 。
//
//
//
// 示例 1：
//
//
//输入：arr = [0,1,0]
//输出：1
//
//
// 示例 2：
//
//
//输入：arr = [0,2,1,0]
//输出：1
//
//
// 示例 3：
//
//
//输入：arr = [0,10,5,2]
//输出：1
//
//
// 示例 4：
//
//
//输入：arr = [3,4,5,1]
//输出：2
//
//
// 示例 5：
//
//
//输入：arr = [24,69,100,99,79,78,67,36,26,19]
//输出：2
//
//
//
//
// 提示：
//
//
// 3 <= arr.length <= 10⁴
// 0 <= arr[i] <= 10⁶
// 题目数据保证 arr 是一个山脉数组
//
//
//
//
// 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
// Related Topics 数组 二分查找 👍 223 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _852_山脉数组的峰顶索引 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 6, 9, 2};

        _852_山脉数组的峰顶索引 v = new _852_山脉数组的峰顶索引();
        int i = v.peakIndexInMountainArray(array);
        System.out.println(i);
    }


    /**
     * 局部最大值
     *
     * 山脉数组的峰顶索引
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r=arr.length -2;
        int ans = 0;
        while(l <= r ){
            int  mid = l +((r - l)>> 1);
            if(arr[mid]>arr[mid+1]){
                ans = mid;
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return ans;
    }


    /**
     * 局部最小
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray02(int[] arr) {
        int l = 1;
        int r = arr.length - 2;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
