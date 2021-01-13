//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2879 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //问题可以简化成,已知固定first指针,求指针往后剩下的数组中,是否存在两个数相加为target - nums[first],指针second固定剩余数组的头部,指针third固定在剩余数组的尾部,若nums[second] + nums[third] > target ,意味着third要左移了,反之需要second右移,这就体现了双指针的思想:当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2)减少至 O(N)。
        int len = nums.length;
        ArrayList<List<Integer>> res = new ArrayList();
        // 先将数组进行排序
        Arrays.sort(nums);
        //定义三个指针:指针3初始定义在数组的末尾

        for (int first = 0; first < len - 2; first++) {
            int third = len - 1;
            // 指针1初始定义在数组头部,且后序只会更新到倒数第三个位置
            int target = 0 - nums[first];
            if (first > 0 && nums[first - 1] == nums[first]) {  // 如果指针当前位置的值和上一个位置的值相等则跳过当轮循环
                continue;
            }
            // 指针2初始定义在指针1的下一个,且后序只会更新到倒数第二个位置
            for (int second = first + 1; second < len - 1; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {  // 如果指针当前位置的值和上一个位置的值相等则跳过当轮循环
                    continue;
                }
                while (third > second && nums[second] + nums[third] > target) {  // 如果2,3两个指针的和大于target则3前移
                    third--;
                }
                // 此时可能是3指针移动到了2指针上,也有可能是2,3指针的和小于等于了target
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    ArrayList<Integer> arrList = new ArrayList();
                    arrList.add(nums[first]);
                    arrList.add(nums[second]);
                    arrList.add(nums[third]);
                    res.add(arrList);
                }
                // nums[second] + nums[third] < target的情况直接进入下一轮循环
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
