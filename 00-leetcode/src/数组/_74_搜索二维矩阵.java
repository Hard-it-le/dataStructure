package 数组;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 */
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10⁴ <= matrix[i][j], target <= 10⁴
//
// Related Topics 数组 二分查找 矩阵 👍 529 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _74_搜索二维矩阵 {
    /**
     * 二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //定义m和n
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        //定义左右指针
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //计算二维矩阵中对应的行列号，取出对应元素
            int midElement = matrix[mid / n][mid % n];
            if (midElement < target) {
                left = mid + 1;
            } else if (midElement > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };
        int target = 31;
        _74_搜索二维矩阵 v = new _74_搜索二维矩阵();
        boolean b = v.searchMatrix(arr, target);
        System.out.println(b);
    }
}
