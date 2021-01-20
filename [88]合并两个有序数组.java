//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中
//的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// nums1.length == m + n 
// nums2.length == n 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 738 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m-1;  // 指针pointer1指向nums1中的最大值
        int pointer2 = n-1;  // 指针pointer2指向nums2中的最大值
        int pointer = m+n-1; // 指针pointer指向当前需要确定的合并后的nums1中的位置

        while(pointer1 >= 0 && pointer2 >= 0){
            if(nums2[pointer2] >= nums1[pointer1]){  // 此时nums2[pointer2]是未经过排序的元素中的最大值,将其放在nums1的pointer位置
                nums1[pointer--] = nums2[pointer2--];
            }else{// nums[pointer2] < nums[pointer1] 此时nums1[pointer1]是未经过排序的元素中的最大值,将其放在nums1的pointer位置
                nums1[pointer--] = nums1[pointer1--];
            }
        }
        System.arraycopy(nums2, 0 , nums1, 0, pointer2+1); //将nums1的[0,pointer2]的位置的元素由nums2的[0,pointer2]代替
        // 当nums1和nums2中的最小值在nums2中时,一定会出现pointer1==-1的情况,将nums2中[0,pointer2]的有序子数组直接填充到nums1的[0,pointer2]中
        // 当nums1和nums2中的最小值在nums1中时,一定会出现pointer2==-1的情况,nums1已经满足要求.System.arraycopy(nums2, 0 , nums1, 0, 0)未执行
    }
}

/** public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 代码解释:
 　　Object src : 原数组
    int srcPos : 从元数据的起始位置开始
 　　Object dest : 目标数组
 　　int destPos : 目标数组的开始起始位置
 　　int length  : 要copy的数组的长度
 */
//leetcode submit region end(Prohibit modification and deletion)
