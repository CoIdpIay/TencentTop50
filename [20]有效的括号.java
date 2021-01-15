//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2059 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 将括号组成的字符串中的字符逐个放入进栈
        Stack stack = new Stack();
        // 用HashMap存放对应的括号
        HashMap map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号则直接放入
            if(s.charAt(i) == '(' || s.charAt(i) == '['||s.charAt(i) =='{'){
                stack.add(s.charAt(i));
            }else{
                // 如果是右括号,先判断栈是否为空,如果是空,字符串直接无效
                // 再判断栈顶是不是对应的左括号
                // 如果是对应的,则弹出栈顶元素ls
                // 如果不是对应的,则字符串无效
                if(stack.size() == 0){
                    return false;
                }else if( map.get(stack.peek()).equals(s.charAt(i)) ){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
