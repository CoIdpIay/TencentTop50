//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2112 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //     // 方法一:暴力破解
        //     if(height.length <= 1){
        //         return 0;
        //     }
        //     int maxWater = Integer.MIN_VALUE;
        //     int i;
        //     int j;
        //     for(i = 0;i< height.length; i++){
        //         for(j = i + 1 ; j< height.length;j++){
        //             if(Math.min(height[i],height[j]) * (j - i) > maxWater){
        //                 maxWater = Math.min(height[i],height[j]) * (j -i);
        //             }
        //         }
        //     }
        // return maxWater;

        //  方法二:双指针
        //  指定一个头指针和尾指针,此时长方形的底已经是最大长度了,接下来移动指针的话,底肯定会缩小,为了保持面积是增加的
        //  趋势,选择将指向的较小的值的指针进行移动.
        int head = 0;
        int tail = height.length -1;
        int res = 0;
        int maxWater = 0;
        while(tail > head){
            res = (tail - head) * Math.min(height[head],height[tail]);
            if(maxWater < res){
                maxWater = res;
            }

            if(height[head]<=height[tail]){
                head++;
            }else{
                tail--;
            }
        }
        return maxWater;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
