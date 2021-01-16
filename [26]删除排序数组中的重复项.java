//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1784 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = 1; // 记录当前已经排序的数组的长度
        for(int i = 0 ; i< nums.length -1 ; i++){
            int k = nums.length - 1;
            int temp = 0;
            // nums[i]是目前已经经过排序的最大值,期望找到大于这个值且最接近这个值的值和它的一下位nums[i+1]互换位置
            while(nums [k] > nums[i]){
                k--;
            }
            if(k == nums.length -1){ // 如果末尾的k指针已经不动了说明当前的nums[i]已经是全局最大了,证明已经排序结束
                return len;
            }else{
                // 循环结束意味着nums[k] <= nums[i],此时需要交换的是nums[k+1] 和nums[i+1]
                temp = nums[k+1];
                nums[k+1] = nums[i+1];
                nums[i+1] = temp;
                len ++;  // 每进行一次交换意味着去重数组又增加了一位
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
