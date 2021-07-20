import printer.BinaryTreeInfo;

import java.util.Comparator;

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
public class BinarySearchTree<E>  implements BinaryTreeInfo {

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
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
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
        if (comparator != null){
            return comparator.compare(e1, e2);
        }
       return ((Comparable<E>)e1).compareTo(e2);
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
            if (compare >0) {
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

}
