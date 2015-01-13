import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/14.
 */
public class replace_ip {

    public ArrayList<String> restoreIpAddresses(String s) {

        ArrayList<String> ret = new ArrayList<String>();
        dfs(s,0,"",ret);
        return ret;
    }

    public void dfs(String s, int count, String str, ArrayList<String> ret){
        if(count==4&&s.length()==0){
            ret.add(str.substring(0,str.length()-1));
            return;
        }
        if(count>=4){
            return;
        }

        for(int i = 1;i<4&&i<=s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(isValid(prefix)){
                dfs(suffix,count+1,str+prefix+".",ret);
            }
        }
    }

    public boolean isValid(String str){
        int tmp = Integer.parseInt(str);
        if(tmp==0&&str.length()>1){
            return false;
        }

        if(tmp>255){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        replace_ip r = new replace_ip();
        System.out.println(r.restoreIpAddresses("0000"));
    }
}
