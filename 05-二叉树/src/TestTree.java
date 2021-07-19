/**
 * @author yujiale
 * @Classname TestTree
 * @Description TODO
 * @Date 2021/7/19 下午8:10
 * @Created by yujiale
 */
public class TestTree {
    /**
     * 如果一个完全二叉树有768个节点，求叶子节点的个数
     * ** 假设叶子节点个数为n0，度为1的节点个数为n1，度为2的个数为n2
     * 那么n= 2n0+n1-1
     * 注意：完全二叉树的n1要么为0，要么为1
     * ** 如果n1为1，则n=2n0，则n为偶数
     * *** 叶子节点个数n0=n/2，非叶子节点个数 n1+n2 = n/2
     * ** 当n1为0，则n=2n0-1，则n为奇数
     * *** 叶子节点个数为n0=（n+1）/2，非叶子节点个数   n1+n2 = （n-1）/2
     *
     * 总节点数量为n，叶子节点数量为n0
     * //向下取整
     * 那么n0 = floor（n/2 + 1/2）
     * == floor（（n+1）/2）
     * == floor （n+1） >> 1
     *
     * ** 总结： 叶子节点数量是 n0 = floor（（n+1）/2）=ceiling（n/2）
     * ** 总结： 非叶子节点数量是 n1+n2 = floor（n/2）=ceiling（（n-1）/2）
     *
     */
}
