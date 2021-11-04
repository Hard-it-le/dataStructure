package 数组;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 */
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
// 示例 3：
//
//
//输入：matrix = [[1]]
//输出：[[1]]
//
//
// 示例 4：
//
//
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
//
//
//
//
// 提示：
//
//
// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
// Related Topics 数组 数学 矩阵 👍 1043 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _48_旋转图像 {
    /**
     * 数学方法
     *
     * 待看
     *
     * @param matrix
     */
    public void rotate01(int[][] matrix) {
        int n = matrix.length;
        //1、转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2、翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * 方法二：分治思想，分为四个子矩阵分别考虑
     *
     * @param matrix
     */
    public void rotate02(int[][] matrix) {
        int n = matrix.length;
        // 遍历四分之一矩阵，左上角
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                // 对于matrix[i][j], 需要找到不同的四个矩阵中对应的另外三个位置和元素
                // 定义一个临时数组，保存对应的四个元素
                int[] temp = new int[4];
                int row = i;
                int col = j;
                // 行列转换的规律：row + newCol  = n - 1, col = newRow
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }

                // 再次遍历要处理的四个位置，将旋转之后的数据填入
                for (int k = 0; k < 4; k++) {
                    // 用上一个值替换当前的位置
                    matrix[row][col] = temp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    /**
     * 方法三：改进方法二
     *
     * @param matrix
     */
    public void rotate03(int[][] matrix) {
        int n = matrix.length;
        // 遍历四分之一矩阵
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                // 将上一个位置的元素填入
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] image2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        _48_旋转图像 v = new _48_旋转图像();
        v.rotate01(image1);
        v.rotate01(image2);
        v.printImage(image1);
        v.printImage(image2);
    }

    private void printImage(int[][] image) {
        System.out.println("image:");
        for (int[] line : image) {
            for (int point : line) {
                System.out.print(point + "\t");
            }
            System.out.println();
        }
    }
}
