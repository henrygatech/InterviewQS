import java.util.ArrayList;

/**
 * Created by Henry on 2014/11/29.
 */
public class restore_ip {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ret  = new ArrayList<String>();
        helper(s,"",0,ret);
        return ret;
    }

    public void helper(String s, String str, int count, ArrayList<String> ret){
        if(count==4&&s.length()==0){
            ret.add(str);
            return;
        }
        if(count>4||s.length()<=0)
            return;
        for(int i = 1;i<4&&i<=s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(isValid(prefix)){
                String tmp = str;
                if(count>1){
                    str+="."+prefix;
                }
                else{
                    str+=prefix;
                }
                helper(suffix,str,count+1,ret);
                str = tmp;
            }
        }
    }

    public boolean isValid(String str){
        if(str.length()==0){
            return false;
        }
        if(Integer.parseInt(str)==0&&str.length()>1){
            return false;
        }
        if(Integer.parseInt(str)<0||Integer.parseInt(str)>255)
            return false;
        return true;
    }

    public static void main(String[] args){
        restore_ip r = new restore_ip();
        r.restoreIpAddresses("0000");
    }

}
