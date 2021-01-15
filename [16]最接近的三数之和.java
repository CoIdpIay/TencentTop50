//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 660 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // 排序后用双指针
        int absDiff = Integer.MAX_VALUE; // 记录当前最接近target的三数之和与target的差的绝对值
        int res = 0; // 记录最终输出结果
        int j ; // 第二个指针
        int k ; // 第三个指针
        for (int i = 0; i < nums.length - 2; i++) { // 第一个指针
            j = i + 1;
            k = nums.length - 1;
            while( j < k ){
                // 首先判断当前三个指针的和与target的距离是否是最近的,通过绝对值来表征
                // 如果是最近的,就记录下三个指针的和,并更新最近的距离
                if(absDiff > Math.abs(nums[i] + nums[j] + nums[k] - target)){
                    absDiff =  Math.abs(nums[i] + nums[j] + nums[k] - target);
                    res = nums[i] + nums[j] + nums[k];
                }
                // 双指针进一步向target逼近
                if(nums[i] + nums[j] + nums[k] == target){
                    return target;
                }else if(nums[i] + nums[j] + nums [k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
