//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1421 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // 在达到第n阶台阶之前,我可能处于第n-1阶台阶或者第n-2阶台阶
        // 所以到达第n阶台阶的方法总数为第n-1阶和第n-2阶方法之和
        // f(n) = f(n-1) + f(n-2)

        // if(n <= 2){
        //     return n;
        // }
        // return climbStairs(n-1) + climbStairs(n-2) ;
        // 直接递归超出时间限制,暂未学过dp,考虑用斐波那契数列做
        if(n<=2){
            return n;
        }
        int temp1 = 1;
        int temp2 = 2;
        int temp = 0;  // 临时存储
        // 部分斐波那契数列:[1,2,3,5,8.......],根据题目背景,去掉头部的1之后再对应台阶n,其中数列的第n项的值就是方法总数
        for(int i = 0; i< n-2 ;i++){
            temp = temp1+temp2;
            temp1 = temp2;
            temp2 = temp;
        }
        return temp2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
