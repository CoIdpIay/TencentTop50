//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1358 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        //方法一:用字符串
        //     // 如果是负数则肯定不是回文数
        //     if(x < 0){
        //         return false;
        //     }
        //     // 转化成字符串操作
        //     String s = String.valueOf(x);
        //     int len = s.length();
        //     // 如果字符串的长度是奇数,则初始情况下i = j
        //     // 如果字符串的长度是偶数,则初始情况下j = i+1
        //     for(int i = (len -1)/ 2,j = len /2 ;i>= 0;i--,j++ ){
        //         if(s.charAt(i) != s.charAt(j)){
        //             return false;
        //         }
        //     }
        //     return true;
        // }

        //方法二:用数学方法
        // 当x为负数,或者是x是以0结尾且不为0的数,直接判定不是回文数
        if(x < 0 || (x!= 0 && x % 10 == 0)){
            return false;
        }
        int res = 0;
        // 将x的后半部分反转用res表示,不断将x的尾部转移到res中,当x大于res时候说明已经过了中位
        while(x > res){
            res = res * 10 + x % 10;
            x /= 10;
        }
        // 如果数字长度是奇数退出条件是res > x,将res的最后一位也就是中位通过整除10来去掉,再进行比较
        // 如果数字长度是偶数,如果它是回文数,则一定会出现x = res 并退出循环的情况,如果不是回文数则也能通过比较x和res/10来直接否定
        return (x == res || x == res /10);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
