package 二叉树;

/**
 * @author yujiale
 * @Classname TreeNode
 * @Description TODO
 * @Date 2021/7/26 下午4:28
 * @Created by yujiale
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
