import java.util.HashSet;

/**
 * Created by Henry on 2015/1/4.
 */
public class isMultiple {

    /*
    有一种String,是把一个更短的String重复n次而构成的，那个更短的String长度至少为
    2，输入一个String写代码返回T或者F
    例子：
    "abcabcabc"  Ture   因为它把abc重复3次构成
    "bcdbcdbcde" False  最后一个是bcde
    "abcdabcd"   True   因为它是abcd重复2次构成
    "xyz"       False  因为它不是某一个String重复
    "aaaaaaaaaa"  False  重复的短String长度应至少为2（这里不能看做aa重复5次)
    要求算法复杂度为O(n)
     */

    public boolean isMulti(String str){
        HashSet<Character> set = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        String repeat  = "";
        for(int i = 0;i<str.length();i++){
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
            else{
                repeat = sb.toString();
                break;
            }
        }
        if(repeat.length()<2){
            return false;
        }
        if(str.length()%repeat.length()!=0)
            return false;

        for(int i = 0;i<str.length();i++){
            if(!(str.charAt(i)==repeat.charAt(i%repeat.length()))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        isMultiple i = new isMultiple();
        System.out.println(i.isMulti("xyz"));
    }

}
