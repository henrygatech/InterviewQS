import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Henry on 2014/12/30.
 */
public class word_break_ii {

    public ArrayList<String> tokenize(String s, HashSet<String> dict) {
        return helperOld(s, dict);
    }

    public ArrayList<String> helperOld(String str, HashSet<String> dict){
        ArrayList<String> ret = new ArrayList<String>();
        if(str.length()==0){
            ret.add("");
            return ret;
        }
        for(int i = 0;i<=str.length();i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i);
            if(dict.contains(prefix)){
                ArrayList<String> res = helperOld(suffix,dict);
                for(String s: res){
                    ret.add((prefix+" "+s).trim());
                }
            }
        }
        return ret;
    }

    public ArrayList<String> helper(String str, Set<String> dict, HashMap<String,ArrayList<String>> map){
        if(map.containsKey(str)){
            return map.get(str);
        }
        ArrayList<String> ret = new ArrayList<String>();
        if(str.length()==0){
            ret.add("");
            return ret;
        }
        for(int i = 0;i<=str.length();i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i);
            if(dict.contains(prefix)){
                dict.remove(prefix);
                ArrayList<String> res = helper(suffix,dict,map);
                for(String s: res){
                    ret.add((prefix+" "+s).trim());
                }
                dict.add(prefix);
            }
        }
        map.put(str,ret);
        return ret;
    }

    public boolean isWordBreak(String s, Set<String> dict) {
        if(s.length()==0){
            return true;
        }
        for(int i = 0;i<=s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(dict.contains(prefix)){
                if(isWordBreak(suffix, dict))
                    return true;
            }
        }
        return false;
    }

    //prefix = i
    //        suffix  = lovexyz

    public ArrayList<String> tokenize1(String s, HashSet<String> dict){
        return helper(s,dict);
    }

    public ArrayList<String> helper(String str, HashSet<String> dict){
        ArrayList<String> ret = new ArrayList<String>();
        if(str.length()==0){
            ret.add("");
            return ret;
        }
        boolean isSplitable = false;
        for(int i = 0; i<= str.length();i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i);
            if(dict.contains(prefix)){
                isSplitable = true;
                ArrayList<String> remain = helper(suffix,dict);
                if(remain==null) return null;
                for(String s: remain){
                    String tmp = prefix+" " +s;
                    ret.add(tmp);
                }
            }
        }
        return isSplitable?ret:null;
    }

    public static void main(String[] args){
        word_break_ii w = new word_break_ii();
        HashSet<String> set = new HashSet<String>();
        //"cat", "cats", "and", "sand", "dog"
        String str = "ilovexyz";
        set.add("i");
        set.add("love");
        set.add("mongo");
        ArrayList<String> ret = w.tokenize("ilovexyz", set);
            for(String s : ret){
                System.out.println(s);
            }

    }

}
