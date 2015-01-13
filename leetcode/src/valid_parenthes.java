import java.util.Stack;

/**
 * Created by Henry on 2014/12/6.
 */
public class valid_parenthes {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(stk.isEmpty()){
                    return false;
                }
                else if(stk.peek()!=s.charAt(i)){
                    return false;
                }
                else{
                    stk.pop();
                }
            }
        }

        return stk.isEmpty()?true:false;
    }

    public static void main(String[] args){
        valid_parenthes v = new valid_parenthes();
        System.out.println(v.isValid("()"));
    }

}
