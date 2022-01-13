package 数组;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/27
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {

        int[] ints = {2, 3};
        int target = 3;

        int[] ints1 = searchRange(ints, target);
        System.out.println(ints1);

    }

    public static int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1 && nums[0] != target) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        if (nums.length == 2 && (nums[0] == nums[1]) && (nums[1] == target)) {
            return new int[]{0, 1};
        }
        if (nums.length == 2 && (nums[0] == nums[1]) && (nums[1] != target)) {
            return new int[]{0, 1};
        }

        int l = 0;
        int n = nums.length;
        int r = n;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[r] != target) {
            return new int[]{-1, -1};
        }

        int left = r;

        l = 0;
        r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int right = l;


        return new int[]{left, right};
    }
}
