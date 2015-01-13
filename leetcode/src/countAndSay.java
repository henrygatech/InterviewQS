/**
 * Created by Henry on 2014/12/4.
 */
public class countAndSay {

    public String countAndSay(int n) {

        String ret = "1";
        while(n-1>0){
            ret = say(ret);
            n--;
        }
        return ret;
    }

    public String say(String s){
        if(s.length()==1){
            return "1"+s.charAt(0);
        }
        String ret = "";
        int num = 1;
        int i = 0;
        for( i = 0;i<s.length()-1;i++){
            if(s.charAt(i+1)==s.charAt(i)){
                num++;
            }
            else{
                ret+=num+"";
                ret+=s.charAt(i)+"";
                num=1;
            }
        }
        ret+= num+"";
        ret+= s.charAt(i)+"";

        return ret;
    }


    public static void main(String[] args){
        countAndSay c = new countAndSay();
        c.countAndSay(4);
    }

}
