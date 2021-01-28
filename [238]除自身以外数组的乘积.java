//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 701 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 方法1:用两个数组l,r分别盛放nums中某个数字左边所有数字的乘积和右边所有数字的乘积
        // 对于nums中的第一个元素,因为其左边没有元素,所以l[0] = 1;同理r[nums.length - 1] = 1;
        // 以[1,2,3,4]为例.l=[1,1,2,6],r=[24,12,4,1],res=[24,12,8,6]

        // int [] l = new int[nums.length];
        // l[0] = 1;
        // for(int i = 1;i<nums.length;i++){
        //     l[i] = nums[i-1]*l[i-1];
        // }

        // int [] r = new int [nums.length];
        // r[nums.length-1] = 1;
        // for(int j = nums.length -2 ; j>=0;j--){
        //     r[j] = nums[j+1]*r[j+1];
        // }

        // int [] res = new int[nums.length];
        // for(int i = 0;i<nums.length;i++){
        //     res[i] = l[i] * r[i];
        // }
        // return res;

        // 方法2:其实是对方法1的改进,直接在方法1的l数组上直接更新出最终的答案,不需要额外开辟r数组的空间
        int [] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1;i<nums.length;i++){
            res[i] = nums[i-1]*res[i-1];
        }
        // 此时的res其实和方法1中的l数组一样的功能,都是记录nums数组中的左侧乘积
        // 接下来通过一个遍历来完成右侧乘积的计算和res的更新
        int r = 1;
        for(int j = nums.length -1;j>=0;j--){
            res[j] *= r;
            r*= nums[j];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
