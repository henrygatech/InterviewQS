import java.util.*;

/**
 * Created by Henry on 2014/12/12.
 */
public class word_ladder_i {
    public int ladderLength(String start, String end, Set<String> dict) {
        return bfs(start,end,dict);
    }

    public int bfs(String start, String end, Set<String> dict){
        Queue<String> q = new LinkedList<String>();
        Queue<Integer> dist = new LinkedList<Integer>();
        q.offer(start);
        dist.offer(1);
        while(!q.isEmpty()){
            String tmp = q.poll();
            int dis = dist.poll();
            if(tmp.equals(end)){
                return dis;
            }

            ArrayList<String> list = getNeighbors(tmp,dict);
            for(String str:list){
                q.offer(str);
                dist.offer(dis+1);
            }
        }
        return 0;
    }

    public ArrayList<String> getNeighbors(String str,Set<String> dict){
        ArrayList<String> ret = new ArrayList<String>();
        char[] strarr = str.toCharArray();
        for(int i = 0;i<strarr.length;i++){
            for(char j = 'a';j<='z';j++){
                char t = strarr[i];
                strarr[i] = j;
                String tmp = new String(strarr);
                if(dict.contains(tmp)){
                    ret.add(tmp);
                    dict.remove(tmp);
                }
                strarr[i] = t;
            }
        }

        return ret;
    }

    public static void main(String[] args){
        word_ladder_i w = new word_ladder_i();
        //"a", "c", ["a","b","c"]
        HashSet<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dog");
        set.add("dot");
        w.ladderLength("hot","dog",set);

    }
}
