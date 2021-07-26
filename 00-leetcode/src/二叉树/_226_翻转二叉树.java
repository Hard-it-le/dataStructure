package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yujiale
 * @Classname _226_翻转二叉树
 * @Description TODO
 * @Date 2021/7/26 下午4:27
 * @Created by yujiale
 * //翻转一棵二叉树。
 * //
 * // 示例：
 * //
 * // 输入：
 * //
 * //      4
 * //   /   \
 * //  2     7
 * // / \   / \
 * //1   3 6   9
 * //
 * // 输出：
 * //
 * //      4
 * //   /   \
 * //  7     2
 * // / \   / \
 * //9   6 3   1
 * //
 * // 备注:
 * //这个问题是受到 Max Howell 的 原问题 启发的 ：
 * //
 * // 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * // Related Topics 树 深度优先搜索 广度优先搜索 二叉树
 * // 👍 927 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        /**
         * 前序遍历
         */
        // TreeNode tmp = root.left;
        // root.left = root.right;
        // root.right = tmp;
        // invertTree(root.left);
        // invertTree(root.right);

        return root;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        return root;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
