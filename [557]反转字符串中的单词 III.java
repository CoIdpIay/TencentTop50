//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 268 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        // String [] splitRes = s.split(" ");
        // String res = "";
        // String temp;
        // for(int i = 0;i<splitRes.length;i++){
        //     temp = splitRes[i];
        //     splitRes[i] ="";
        //     for(int j = temp.length() - 1;j >= 0;j--){
        //         splitRes[i] += temp.charAt(j);
        //     }
        // }
        // for(String str : splitRes){
        //     res += " " +  str;
        // }
        // return res.substring(1);
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (end < chars.length) { // 当没有遍历到最后时
            while (end < chars.length && chars[end] != ' ') {  // 当没有遍历到最后且没有遍历到空格
                // 为什么要加end < chars.lenth : 当遍历到最后一个单词时,退出的条件不能时chars[end] != '',那样会报数组越界
                end++;
            }
            // 此时的end指向单词后面的空格,然后反转至单词末尾到单词开头进行反转
            for (int i = end - 1; i >= start; i--) {
                sb.append(chars[i]);
            }
            // 如果是最后一个单词,到这里不执行这一步,因为end == chars.length
            if (end < chars.length) {
                sb.append(chars[end++]); // 将空格加入,并将end移动到下一个单词的开头
                start = end;  // 调整start的位置也到下一个单词的开头
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
