/**
 * Created by Henry on 2014/12/5.
 */
public class strstr {

    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }

        for(int i = 0;i<haystack.length();i++){
            if(haystack.charAt(0)==needle.charAt(0)){
                int j = 0;
                for(j = 0;j<needle.length();j++){
                    if(i+j>=haystack.length()||haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }
                }
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        strstr s = new strstr();
        s.strStr("a","a");
    }
}
