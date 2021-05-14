package 链表;
//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 536 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        /**
         * 递归
         */
        //1.判断head是否为null或者head.next是否为null
        if (head == null || head.next == null) {
            return head;
        }
        //设置tmp等于head的下一个节点
        ListNode tmp = head.next;
        //通过调用removeElements方法，把head.next节点当参数。
        tmp = removeElements(head.next, val);
        //如果head.val等于val，则返回head.next；否则返回head本身
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
