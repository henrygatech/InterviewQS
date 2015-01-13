import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/2.
 */
public class text_justificaton {
    public ArrayList<String> fullJustify(String[] words, int L) {

        ArrayList<String> ret = new ArrayList<String>();
        if(words.length==0){
            return ret;
        }
        if(L==0){
            ret.add("");
            return ret;
        }
        int sum = 0;
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0;i<words.length;i++){
            if(sum+words[i].length()>L){
                ret.add(arange(list,L,sum-1,false));
                sum = 0;
                list = new ArrayList<String>();
                i--;
            }
            else if(i==words.length-1){
                list.add(words[i]);
                ret.add(arange(list,L,sum+words[i].length(),true));
            }
            else{
                sum+=words[i].length();
                sum+=1;
                list.add(words[i]);
            }
        }

        return ret;
    }

    public String arange(ArrayList<String> list, int L, int sum, boolean isLast){
        String str = "";
        if(list.size()==1){
            str+=list.get(0);
            int count = L-list.get(0).length();
            while(count>0){
                str+=" ";
                count--;
            }

            return str;
        }
        if(isLast==true){
            for(int i = 0;i<list.size();i++){
                str+=list.get(i);
                str+=" ";
            }

            int count = L-str.length();
            while(count>0){
                str+=" ";
                count--;
            }

            return str;
        }

        int even = (L-sum)/(list.size()-1);
        boolean flag = ((L-sum)%(list.size()-1)>0)?true:false;//if flag == true, have some remains -> add more

        for(int i = 0;i<list.size();i++){
            if(i==0||i<list.size()-2){
                str+=list.get(i);
                str+=" ";
                int count = even;
                while(count>0){
                    str+=" ";
                    count--;
                }
                if(flag==true){
                    str+=" ";
                }

            }
            else if(i==list.size()-2){
                str+=list.get(i);
                int count = L- str.length()-list.get(list.size()-1).length();
                while(count>0){
                    str+=" ";
                    count--;
                }
            }
            else{
                str+=list.get(i);
            }
        }

        return str;
    }

    public static void main(String[] args){
        text_justificaton t = new text_justificaton();
        String[] words = {"What","must","be","shall","be."};
        t.fullJustify(words,12);
    }

}
