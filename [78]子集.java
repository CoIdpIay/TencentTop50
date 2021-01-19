//给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 955 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    // 迭代法实现子集枚举
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {  // n个元素组成的数组共有2^n个子集,以n=3为例,1 << 3 == 1000(二进制)==8(十进制)个子集
            t.clear();
            // 每个子集最多是由n==3个元素组成,将第mask个子集的mask转换成二进制形式进行枚举,若第i位为1,说明nums[i]在这个子集中,如果为0,说明不在
            // 以[1,2,3]为例,如果它的第5(二进制形式为101)个子集,是由两个1所在的1,3组成的即[1,3]
            for (int i = 0; i < n; ++i) {  //
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
