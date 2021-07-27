/**
 * @author yujiale
 * @Classname restructureTree
 * @Description TODO
 * @Date 2021/7/26 下午4:55
 * @Created by yujiale
 * 根据遍历结果重构二叉树
 * 以下结果可以保证重构出唯一的一颗二叉树
 * ** 前序遍历+中序遍历
 * *** 前序遍历 根节点  左字树 右子树
 * *** 中序遍历 左字树  根节点 右子树
 * ** 后序遍历+中序遍历
 * *** 后序遍历 左字树  右子树 根节点
 * *** 中序遍历 左字树  根节点 右子树
 * <p>
 * 前序遍历+后序遍历
 * ** 如果二叉树是真二叉树，那么可以遍历重构二叉树并且结果唯一
 * ** 不然结果不唯一
 */
public class RestructureTree {
    /**
     * 前序遍历+中序遍历重构二叉树
     * 前序遍历： 4 2 1 3 6 5
     * 中序遍历： 1 2 3 4 5 6
     */
    static void preorderAndInorder() {
    }

    /**
     * 后序遍历+中序遍历重构二叉树
     * 中序遍历： 1 2 3 4 5 6
     * 后序遍历： 2 1 3 5 6 4
     */
    static void postorderAndInorder() {

    }

    /**
     * 前序遍历+后序遍历
     */
    static void preorderAndpostorder() {

    }

    public static void main(String[] args) {
        preorderAndInorder();
    }
}
