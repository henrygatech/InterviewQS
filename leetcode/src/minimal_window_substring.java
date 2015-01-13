import java.util.HashMap;

/**
 * Created by Henry on 2015/1/3.
 */
public class minimal_window_substring {
    public String minWindow(String S, String T) {

        int minLen = Integer.MAX_VALUE;
        String ret = "";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> has = new HashMap<Character,Integer>();
        for(int i = 0;i<T.length();i++){
            if(map.containsKey(T.charAt(i))){
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else{
                map.put(T.charAt(i),1);
            }
            has.put(T.charAt(i),0);
        }
        int left = 0;
        int right = 0;
        while(right<S.length()){
            if(map.containsKey(S.charAt(right))){
                has.put(S.charAt(right),has.get(S.charAt(right))+1);
                if(satisfy(map,has)){
                    while(!map.containsKey(S.charAt(left))||has.get(S.charAt(left))>map.get(S.charAt(left))){
                        if(map.containsKey(S.charAt(left))&&has.get(S.charAt(left))>map.get(S.charAt(left)))
                            has.put(S.charAt(left),has.get(S.charAt(left))-1);
                        left++;
                    }
                    if(minLen>(right-left+1)){
                        minLen = right-left+1;
                        ret = S.substring(left,right+1);
                    }
                }
            }
            right++;
        }
        return ret.length()>S.length()?"":ret;
    }

    public boolean satisfy(HashMap<Character,Integer> map, HashMap<Character,Integer> has){
        for(Character ch:map.keySet()){
            if(!has.containsKey(ch)||map.get(ch)>has.get(ch)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        minimal_window_substring m = new minimal_window_substring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    }

}
