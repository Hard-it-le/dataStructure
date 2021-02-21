package 链表;


//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
// 示例 1：
//
// 输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
// 示例 2：
// 输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 提示：

// 链表至少包含两个节点。
// 链表中所有节点的值都是唯一的。
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
// 不要从你的函数中返回任何结果。
//
// Related Topics 链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class _237_删除链表中的节点_1 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        //当链表中只有一个元素时
        if (head.val == val) {
            return head.next;
        }
        // 用于遍历链表，找到val对应的结点
        ListNode node = head;
        // 始终指向p所指向的前一个结点
        ListNode pre = node;
        //遍历单链表，查找下一个节点等于目标节点的节点，同时防止空指针
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
            }
            pre = node;
            node = node.next;
        }
        return head;

    }
}
