//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5489 👎 0

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义两个变量temp1和temp2用于遍历两个链表
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        // 定义一个变量temp3,用于辅助创建结果链表
        ListNode temp3 = new ListNode(0);
        ListNode res = temp3;
        ListNode virtualHeadNode = new ListNode();
        virtualHeadNode.next = temp3;
        // 定义一个变量extra用于记录当前位所加的和是否已经大于9
        int extra = 0;
        // 定义一个变量sum用于保存当前位的结果
        int sum = 0;

        // 遍历两个链表,将对应位置相加
        // 如果相加的结果大于9,则将其取模后存放在输出链表的对应位置,同时将extra置为1,参与下一位的运算;
        // 如果相加的结果不大于9,则直接将结果存放在输出链表的对应位置,并且将extra置为0;
        while(true){
            // 如果出现长度不够的情况直接补充0
            if(temp1 == null){
                temp1 = new ListNode(0);
            }
            if(temp2 == null){
                temp2 = new ListNode(0);
            }

            sum = temp1.val + temp2.val + extra;
            if(sum > 9){
                sum  = sum % 10;
                extra = 1;
            }else{
                extra = 0;
            }

            temp3.val = sum;
            temp1 = temp1.next;
            temp2 = temp2.next;

            // 如果两个链表都已经遍历到尽头
            if(temp1 == null && temp2 == null){
                if(extra == 0){
                    // 不需要进位
                }else if(extra == 1){
                    // 需要进位
                    temp3.next = new ListNode(1);
                }
                break;
                // 如果至少一个链表没有遍历到尽头
            }else{
                temp3.next = new ListNode(0);
                temp3 = temp3.next;
            }
        }
        return virtaulHeadNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
