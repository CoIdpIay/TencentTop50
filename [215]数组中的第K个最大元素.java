//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 862 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 先将数组排序,完成之后输入nums[nums.length - k];
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length -1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // 中值
        int temp;
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l == r) {  // 每次当两指针重合(只会在中值处重合)时意味着指针左侧全是小于中值的,指针右侧全是大于中值的
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 当某一个指针率先指向中值时,将另一个指针向自己方向移动
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 再进行左右侧递归前,将两个指针分开
        if(l == r){
            l++;
            r--;
        }

        // 若左侧值大于1个,则进行左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 若右侧值大于1个,则进行右递归
        if (l < right) {
            quickSort(arr, l, right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
