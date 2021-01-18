//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 395 👎 0

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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0,head);  // 虚拟头结点用于遍历
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        while(k > 0){
            // 遍历当前的链表的最后一个结点,将其放在链表的头部
            head = dummyNode.next;
            while(head.next.next != null){
                head = head.next;
            }

            // 将最后一个结点即为head.next,将其放到最前
            ListNode temp = head.next;
            head.next = null;
            temp.next = dummyNode.next;
            dummyNode.next = temp;
            k--;
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
