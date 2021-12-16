/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 22:27 2019/11/13
 * @Modificd By;
 */

/*
* 栈的应用之字符串匹配
* */
import java.util.Stack;
class LeetCode01 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())
                    return false;

                char topchar=stack.pop();
                if(c==')'&&topchar!='(')
                    return false;
                if(c=='}'&&topchar!='{')
                    return false;
                if(c==']'&&topchar!='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new LeetCode01()).isValid("(){}[]"));
        LeetCode01 leetCode01=new LeetCode01();
        System.out.println(leetCode01.isValid("{}(]"));

    }
}