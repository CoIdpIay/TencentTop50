//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1414 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 如果是空数组,则返回0
        if (strs == null) {
            return "";
        }
        // 如果数组长度为1 ,唯一一个字符串就是最长公共前缀
        if (strs.length == 1) {
            return strs[0];
        }
        // 首先找到数组中长度最短的子串
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
                minLenStr = s;
            }
        }

        while (minLen > 0) {
            boolean isFlag = true;
            for (String s : strs) {
                // 假设公共前缀就是长度最短的那个字符串,将其与各个位置上的字符串比较
                // 如果满足即输出这个长度最短的字符串;
                // 如果不满足,则将这个字符串从后向前缩减,再进行比较,直到缩短至长度为0;
                if (!s.substring(0, minLen).equals(minLenStr)) {
                    minLen--;
                    minLenStr = minLenStr.substring(0, minLen);
                    isFlag = false;  // 只要出现了不匹配的情况isFlag就会变成false;
                    break;
                }
            }
            // 每轮小循环之后判断是否已经找到
            if(isFlag == true){
                return minLenStr;
            }
        }
        return minLenStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
