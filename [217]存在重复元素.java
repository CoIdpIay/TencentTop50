//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 358 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 遍历数组中的数,将数作为key存进HashMap中,在存进HashMap中先确定其是否已经存在与HashMap中
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i : nums){
            if(hashMap.containsKey(i)){  // 如果已经存在说明是重复元素
                return true;
            }
            hashMap.put(i,0);  // 如果不存在就将其加入HashMap中
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
