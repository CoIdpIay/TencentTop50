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
        if(head == null){
            return null;
        }
        // 获得链表的长度,并且拿到最后一个结点
        int len =1; // 链表的长度
        ListNode end = head; // 最后的结点
        while(end.next != null){
            end = end.next;
            len++;
        }
        // 如果是空链表,或者k为0或者,k是长度的整数倍,意味着翻转后的链表,头节点不变
        if(head.next == null || k == 0 || k % len == 0){
            return head;
        }
        ListNode dummyNode = new ListNode(0,head);  // 虚拟头结点用于遍历
        ListNode temp = dummyNode;  // 待旋转点的上一个结点
        // 拿到旋转结点的上一个结点,如果k大于len,则取模后遍历
        for(int i =0;i< len - (k%len);i++){
            temp = temp.next;
        }
        dummyNode.next = temp.next;
        temp.next = null;
        end.next = head;   
        return dummyNode.next; 
    }
}
//leetcode submit region end(Prohibit modification and deletion)
