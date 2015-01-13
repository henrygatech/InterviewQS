import java.util.*;

/**
 * Created by Henry on 2014/11/27.
 */
public class word_ladder {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        Queue<Integer> dist = new LinkedList<Integer>();
        HashSet<String> set = new HashSet<String>();
        q.offer(start);
        dist.offer(1);
        while(!q.isEmpty()){
            String tmp = q.poll();
            int curdist = dist.poll();
            if(tmp.equals(end)){
                return curdist;
            }
            set.add(tmp);
            List<String> list = getNeighbors(tmp,dict);
            for(int i = 0;i<list.size();i++){
                if(!set.contains(list.get(i))){
                    q.offer(list.get(i));
                    dist.offer(curdist+1);
                }
            }
        }
        return 0;
    }


    public List<String> getNeighbors(String str, Set<String> dict){
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<str.length();i++){
            char[] charArray = str.toCharArray();
            for(char c = 'a';c<='z';c++){
                charArray[i] = c;
                String newstr = new String(charArray);
                if(dict.contains(newstr)&&!dict.isEmpty()){
                    list.add(newstr);
                    dict.remove(newstr);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        word_ladder w = new word_ladder();
        //"a", "c", ["a","b","c"]
        HashSet<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        w.ladderLength("a","c",set);

    }
}
