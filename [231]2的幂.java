//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 273 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 如果n是2的幂,则n的二进制形式应该只包含一个1其余为都为0
    // 获取到n的二进制形式后,将除了右边第一个1之外的位数全位置为0,再比较操作之后和原数是否相等
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
