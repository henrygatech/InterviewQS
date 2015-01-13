import java.util.*;

/**
 * Created by Henry on 2014/12/10.
 */
public class word_break {

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        return helper(s,dict,map);
    }

    public ArrayList<String> helper(String s, Set<String> dict,HashMap<String,ArrayList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        ArrayList<String> ret = new ArrayList<String>();
        if(s.length()<0){
            return ret;
        }
        if(s.length()==0){
            ret.add("");
            return ret;
        }
        for(int i = 1;i<=s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(dict.contains(prefix)){
                ArrayList<String> res = helper(suffix,dict,map);
                for(int j = 0;j<res.size();j++){
                    ret.add(prefix+" "+res.get(j));
                }
            }
        }
        map.put(s,ret);
        return ret;
    }

    public static void main(String[] args){
        word_break w = new word_break();
        HashSet<String> set = new HashSet<String>();
        //"cat", "cats", "and", "sand", "dog"

        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");

        ArrayList<String> ret = w.wordBreak("catsanddog", set);
        for(String s : ret){
            System.out.println(s);
        }
    }
}
