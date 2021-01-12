//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 
//
// 注意： 
//
// 
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2451 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        // 可以将数字转化成字符串,并把每个字符都用栈的方式存储起来再拼接
        // 以上的思路需要另外开辟空间用于创建栈结构
        // 以下通过数学方法模拟以上流程
        int res = 0;
        while(x != 0){
            // 下面两步模拟的是栈弹出的过程
            int pop = x % 10 ;
            x /= 10;
            // 提前判断:将当前已经构成的数乘上10,判断越界的话,即不管下一次的pop是几都会发生越界,如果相等,则下一次就已经是最后一次弹出操作,判断此时如果大于7
            // 则直接越界,否则不越界,32位整数范围[-2147483648,2147483647]
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7 )){
                return 0;
            }
            // 负数同理
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8 )){
                return 0;
            }
            res = res*10 + pop;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
