//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3085 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s ){
        // 如果字符串是空则不存在子字符串,直接返回null
        if(s == null){
            return null;
        }
        // 定义两个变量分别为start和end分别保存当前最长回文子字符串的首尾
        int start = 0, end = 0;
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 经过观察:回文子字符串长度可能是奇数(以某一个值为中心向两边扩展),可能是偶数(以某一个缝隙向两边扩展)
            // 比较两种情况下的长度,值较大的作为当前的最长回文子字符串的长度
            int len = Math.max(expand(s,i,i),expand(s,i,i+1));
            if(len > (end - start)){
                // 如果当前的子回文字符串的长度已经大于了在此之前的子回文字符串的长度,对start和end进行更新
                start = i - (len -1)/2;
                // 当len为奇数(len-1) /2 和len / 2 结果相等
                // 当len为偶数,从缝隙往两边确实事len / 2 但是缝隙只是用于理解扩展的想象力产物,实际并不存在
                // 所以当通过缝隙左边的i来查找start时需要 -1 ,从而达成奇偶情况下的形式统一.
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    /**
     *
     * @param s  需要查找最大回文子字符串的字符串
     * @param left 左指针
     * @param right 右指针
     * @return 返回的是以某一个值或某个一条缝隙为中心的最大回文子字符串的长度
     */
    public int expand(String s ,int left,int right){
        while(left>= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        return  right - left - 1;
        // 当不满足while循环条件时,left和right已经分别往两边越了一位,
        //所以实际长度为right - left + 1 - 2 = right - left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
