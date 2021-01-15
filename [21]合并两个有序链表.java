//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1481 👎 0

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0,l1);
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return dummyNode.next;
        }
        ListNode temp;
        if(l2.val <= l1.val){
            temp = l2.next;
            dummyNode.next = l2;
            l2.next = l1;
            l1 = dummyNode.next;
            l2 = temp;
            return mergeTwoLists(l1, l2);
        }else{
            while(l1.next != null){
                if(l1.next.val >= l2.val){
                    break;
                }
                l1 = l1.next;
            }
            if(l1.next == null){
                l1.next = l2;
                return dummyNode.next;
            }
            temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = dummyNode.next;
            l2 = temp;
            return mergeTwoLists(l1, l2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
