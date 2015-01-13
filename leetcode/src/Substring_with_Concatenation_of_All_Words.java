import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry on 2015/1/3.
 */
public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(L.length==0)
            return ret;
        int len = L[0].length();
        HashMap<String,Integer> want = new HashMap<String,Integer>();
        HashMap<String,Integer> has = new HashMap<String,Integer>();
        for(String str : L){
            want.put(str,want.get(str)==null?1:(want.get(str)+1));
            has.put(str,0);
        }
        for(int i = 0;i<len;i++){
            int right = i;
            int left = i;
            while(right<=S.length()-len){
                String tmp = S.substring(right,right+len);
                if(want.containsKey(tmp)){
                    while(want.get(tmp)==has.get(tmp)){
                        String lefttmp = S.substring(left,left+len);
                        has.put(lefttmp,has.get(lefttmp)-1);
                        left+=len;
                    }
                    has.put(tmp,has.get(tmp)==null?1:has.get(tmp)+1);
                    if(satisfy(want,has)){
                        ret.add(left);
                    }
                }
                else{
                    has.clear();
                    left = right+len;
                }
                right+=len;
            }
            has.clear();
        }
        return ret;
    }

    public boolean satisfy(HashMap<String,Integer> want, HashMap<String,Integer> has){
        for(String str: want.keySet()){
            if(has.get(str)==null||has.get(str)!=want.get(str)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Substring_with_Concatenation_of_All_Words s = new Substring_with_Concatenation_of_All_Words();
        String[] L = {"a","b","a"};
        s.findSubstring("abababab",L);
    }

}
