import printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yujiale
 * @Classname BinarySeachTree
 * @Description TODO
 * @Date 2021/7/19 下午8:41
 * @Created by yujiale
 * <p>
 * <p>
 * 二叉搜索树是二叉树的一种，应用非常广泛，简称bst，也称为二叉查找树、二叉排序树
 * **特点：任意一个节点的值都大于左字树中所有节点的值
 * **特点：任意一个节点的值都小于右字树中所有节点的值
 * **特点：其左右子树也是二叉搜索树
 * **优点： 提高搜索效率
 * **注意： 二叉搜索树的数据必须具备可比较树（可以自定义比较方式）
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    //根节点
    private Node<E> root;
    //比较器
    private Comparator<E> comparator;

    //默认不传
    public BinarySearchTree() {
        this(null);
    }

    /**
     * 默认传比较器
     *
     * @param comparator
     */
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = ((Node<E>) node);
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = "" + myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        /**
         * 判断是否是叶子节点
         *
         * @return
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * 判断是否有两个节点
         *
         * @return
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    /**
     * 前序遍历
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    /**
     * 递归实现前序遍历
     *
     * @param node
     */
    private void preorderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.element + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    /**
     * 中序遍历
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    /**
     * 递归实现中序遍历
     *
     * @param node
     */
    private void inorderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.element + " ");
        inorderTraversal(node.right);
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    /**
     * 递归实现后序遍历
     *
     * @param node
     */
    private void postorderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.element + " ");
    }

    /**
     * 层序遍历（从上到下、从左到右遍历）
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.print(node.element + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 元素检验是否为空
     *
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

    /**
     * 自定义遍历规则层序遍历
     *
     * @param visitor
     */
    public void levelOrder(visitor<E> visitor) {
        if (root == null || visitor == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) {
                return;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 自定义规则前序遍历
     *
     * @param visitor
     */
    public void preorder(visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        perorder(root, visitor);
    }

    /**
     * 递归前序遍历
     *
     * @param node
     * @param visitor
     */
    private void perorder(Node<E> node, visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        if (visitor.stop == true) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        perorder(node.left, visitor);
        perorder(node.right, visitor);
    }

    /**
     * 自定义规则中序遍历
     *
     * @param visitor
     */
    public void inorder(visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorder(root, visitor);
    }

    /**
     * 递归中序遍历
     *
     * @param node
     * @param visitor
     */
    private void inorder(Node<E> node, visitor<E> visitor) {
        if (node == null || visitor.stop) {
            return;
        }
        inorder(node.left, visitor);
        if (visitor.stop == true) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    public void postorder(visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, visitor<E> visitor) {
        //停止递归终止
        if (node == null || visitor.stop) {
            return;
        }
        postorder(node.left, visitor);
        postorder(node.right, visitor);
        //停止打印
        if (visitor.stop == true) {
            return;
        }
        visitor.stop = visitor.visit(node.element);
    }


    /**
     * 通过外界来自定义遍历逻辑
     *
     * @param <E>
     */
    public static abstract class visitor<E> {
        boolean stop;

        /**
         * @param element
         * @return 如果返回true，就停止遍历
         */
        abstract boolean visit(E element);
    }

    /**
     * 比较类型
     * 返回值= 0 ，代表e1和e2相等
     * 返回值>0，代表e1大于e2
     * 返回值《0，代表e1小于e2
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void remove(E element) {

    }

    public void add(E element) {
        //判断节点的值是否为空
        elementNotNullCheck(element);
        //如果root为空，则添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        //1.首先找到父节点parent，  添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int compare = 0;
        //如果node为null，则表示为最后一个节点的元素的节点为空
        while (node != null) {
            //保存父节点
            parent = node;
            //通过传入的元素和父节点的元素进行比较
            compare = compare(element, node.element);
            //如果结果大于0 ，则表示输入的元素要与右边进行比较
            if (compare > 0) {
                node = node.right;
                //如果结果小于0 ，则表示输入的元素要与左边进行比较
            } else if (compare < 0) {
                node = node.left;
            } else {
                //如果相等，则直接返回
                node.element = element;
                return;
            }
        }
        //2.查看插入到父节点的哪个位置，先创建新节点
        Node<E> newNode = new Node<>(element, parent);
        //3.parent.left = node  或 parent.right = node
        if (compare > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public boolean contains(E element) {
        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        /**
         * 递归方法实现查找二叉树的高度
         */
        return 1 + Math.max(height(node.left), height(node.right));

    }

    /**
     * 迭代方式实现查找二叉树的高度
     * 层序遍历
     */
    public int height1() {
        if (root == null) {
            return 0;
        }
        int height = 0;
        //存储每一层的元素数量
        int levelSize = 1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            //如果levelSize等于0，则访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 判断二叉树是否是完全二叉树
     *
     * @return
     */
    public boolean isCompleteTree() {
        if (root == null) {
            return false;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {
                //后面遍历的节点都必须是叶子节点
                leaf = true;
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

        }
        return true;
    }


    /**
     * 利用前序遍历打印二叉树
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append("[").append(node.element).append("]").append("\n");
        toString(node.left, sb, prefix + "[L]");
        toString(node.right, sb, prefix + "[R]");

    }
}
