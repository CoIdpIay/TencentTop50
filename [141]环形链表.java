//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 912 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 如果不设置O(1)的内存,可以通过HashMap记录每个遍历到的Node的val,如果出现某个val出现两次的
        // 且链表长度大于1的情况就说明有环
        // 考虑O(1)的内存限制,考虑快慢指针
        ListNode slower = head;
        ListNode quicker = head;
        if(head == null){// 链表为空不存在环
            return false;
        }
        if(head.next == null){ // 链表不为空但只有一个节点时不存在环
            return false;
        }
        while(quicker.next != null){ // 当快指针下一个不是空时,将快慢各向后移一个
            slower = slower.next;
            quicker = quicker.next;
            if(quicker.next != null){// 判断快指针下一个是否为空,如果是,说明链表有尽头不存在环
                quicker = quicker.next;// 如果不为空,则快指针继续往后移一个,意味着每次满指针移动一个单位,快指针移动两个单位,如果存在环则一定会出现快指针刷圈追上满指针的时候
            }else{
                return false;
            }
            if(slower.val  == quicker.val){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
