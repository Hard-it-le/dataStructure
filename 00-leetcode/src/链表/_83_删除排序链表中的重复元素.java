package 链表;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 474 👎 0


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
public class _83_删除排序链表中的重复元素 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 递归
         */
        //1。首先判断head是否为空或者head.next是否为null
        if(head == null || head.next == null){
            return  head;
        }
        //2。通过递归方式进行判断
        head.next = deleteDuplicates(head.next);
        //3。判断head.val和head.next.val的值是否相等
        if(head.val == head.next.val){
            head = head.next;
        }
        return  head;
    }
}
