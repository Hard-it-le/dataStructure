package 栈;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2403 👎 0


import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {

    /**
     * [{()}]
     * 1.判断遇见的是左字符，将左字符入栈
     * 2.遇见右字符
     *    a.如果栈为空，说明括号无效
     *    b.如果栈不为空，将栈顶字符出栈，与右字符匹配
     *       如果左右字符不匹配，说明括号无效
     *       如果匹配，继续扫描下一个字符
     * 3.所有的字符扫描完毕后
     *    如果栈为空，则括号有效
     *    如果栈不为空，说明括号无效
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是左字符
            if(c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return  false;
                }
                char left  = stack.pop();
                if(left == '(' && c != ')'){
                    return  false;
                }
                if(left == '{' && c != '}'){
                    return  false;
                }
                if(left == '[' && c != ']'){
                    return  false;
                }
            }
        }
        return  stack.isEmpty();
    }

    private static HashMap<Character, Character> map = new HashMap<>();


   static {
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
    }

    /**
     * 使用hashmap解决问题
     * @param s
     * @return
     */
    public boolean isValidHashMap(String s) {
      Stack<Character> stack = new Stack<>();
      int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char left = stack.pop();
                if (c != map.get(left)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
