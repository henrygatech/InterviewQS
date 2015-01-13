import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry on 2014/12/3.
 */
public class anagrams {

    public List<String> anagrams(String[] strs) {
        int max = 1;
        String maxInd = "-1";

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chari = strs[i].toCharArray();
            Arrays.sort(chari);
            String tmp = new String(chari);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(tmp, list);
            }
        }

        for (String tmp : map.keySet()) {
            if (map.get(tmp).size() > max) {
                max = map.get(tmp).size();
                maxInd = tmp;
            }
        }

        if (maxInd.length() > 0)
            return map.get(maxInd);
        else
            return new ArrayList<String>();
    }

        public static void main(String[] args){
            anagrams a = new anagrams();
            String[] strs = {"",""};
            a.anagrams(strs);
        }


}