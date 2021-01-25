//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1460 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //  迭代:将当前指针的next指向pre,然后将pre , cur 后移
        // ListNode pre = null;
        // ListNode cur = head;
        // while(cur != null){
        //     ListNode next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        // return pre;


        // 递归:
        if (head == null || head.next == null) {
            // 如果head == null 说明是空链表直接返回head(null)
            // head.next == null 是递归的终止条件,意味着找到新的头节点
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head; //考虑到1-->2<--3的情况,当head是1结点,则head.next.next = head实现反转1<--2<--3
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
