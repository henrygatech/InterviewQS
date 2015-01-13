/**
 * Created by Henry on 2014/12/4.
 */
public class countnsay {

    public String countAndSay(int n) {
        String str = "1";
        while(n>1){
            str = helper(str);
            n--;
        }
        return str;
    }

    public String helper(String str){
        String ret = "";
        int num = 1;
        for(int i = 0;i<str.length();i++){
            while(i+1<str.length()&&str.charAt(i)==str.charAt(i+1)){
                num++;
                i++;
            }
            ret += ""+num+str.charAt(i);
        }

        return ret;
    }

    public static void main(String[] args){
        countnsay c = new countnsay();
        c.countAndSay(20);
    }
}
