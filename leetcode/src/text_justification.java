import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2014/11/21.
 */
public class text_justification {

    public List<String> fullJustify1(String[] words, int L) {
        List<String> text = new ArrayList<String>();
        int cur = 0;
        while(cur<words.length){
            int beg = cur;
            int len = 0;
            while(cur<words.length){
                int newlen = len==0? words[cur].length(): len+1+words[cur].length();
                if(newlen>L) break;
                else len = newlen;
                cur++;
            }
            int space = L-len;
            int avgspace = 0;
            if(cur!=beg+1 && cur!=words.length){
                avgspace = space/(cur-beg-1);
                space %= cur-beg-1;
            }
            StringBuilder s = new StringBuilder();
            for(int i=beg;i<cur;i++){
                if(i==beg){
                    s.append(words[i]);
                    continue;
                }
                s.append(' ');
                for(int j=0;j<avgspace;j++)
                    s.append(' ');
                if(space>0 && cur!=words.length){
                    s.append(' ');
                    space--;
                }
                s.append(words[i]);
            }
            for(int i=0;i<space;i++)
                s.append(' ');
            text.add(s.toString());
        }
        return text;
    }

    public List<String> fullJustify(String[] words, int L) {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> list  = new ArrayList<String>();
        int sum = 0;
        for(int i = 0;i<words.length;i++){
            int newsum = (sum==0)?words[i].length():sum+1+words[i].length();
            if(newsum>L){
                //call helper
                helper(list, ret,sum,L,false);//sum = sum-1
                list = new ArrayList<String>();
                sum = 0;
                i--;
            }
            else if(i==words.length-1){
                //cal helper
                list.add(words[i]);
                sum=newsum;
                helper(list,ret,sum,L,true);

            }
            else{
                list.add(words[i]);
                sum=newsum;
            }
        }
        return ret;
    }


    public void helper(ArrayList<String> cur, ArrayList<String> ret,int sum ,int L,boolean isLastLine){


        int space = L-sum;
        int avgspace = 0;
        if(isLastLine){
            StringBuilder s = new StringBuilder();
            for(int i = 0;i<cur.size();i++){
                if(i==cur.size()-1){
                    s.append(cur.get(i));
                    while(space>0){
                        s.append(" ");
                        space--;
                    }
                }else {
                    s.append(cur.get(i));
                    s.append(" ");
                }
            }
            ret.add(s.toString());
            return;
        }
        if(cur.size()!=1){
            avgspace = space/(cur.size()-1);
            space %= (cur.size()-1);
        }
        StringBuilder s = new StringBuilder();
        if(cur.size()==0){
            while(space>0){
                s.append(" ");
                space--;
            }
        }
        for(int i = 0;i<cur.size();i++){
            if(i==cur.size()-1){
                s.append(cur.get(i));
                while(space>0){
                    s.append(" ");
                    space--;
                }
            }
            else{
                s.append(cur.get(i));
                s.append(" ");
                int count = avgspace;
                while(count>0){
                    s.append(" ");
                    count--;
                }
                if(space>0){
                    s.append(" ");
                    space--;
                }
            }
        }
        ret.add(s.toString());
    }

    public static void main(String[] args){
        text_justification t = new text_justification();
        String[] words = {"What","must","be","shall","be."};
        List<String> ret = t.fullJustify(words, 12);
        for(int i = 0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }

    }
}
