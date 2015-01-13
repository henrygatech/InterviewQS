import java.util.ArrayList;

/**
 * Created by Henry on 2014/11/25.
 */
public class palin_part_i {

    public ArrayList<ArrayList<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = true;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(j-i<2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        ArrayList<String> curlist = new ArrayList<String>();
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        dfs(s,0,curlist,ret,dp);
        return ret;


    }

    public void dfs(String s,int start, ArrayList<String> curlist, ArrayList<ArrayList<String>> ret,boolean[][] dp){

        if(start==s.length()){
            ret.add((ArrayList<String>)curlist.clone());
            return;
        }

        for(int i = start;i<s.length();i++){
            if(dp[start][i]==true){
                curlist.add(s.substring(start,i+1));
                dfs(s,i+1,curlist,ret,dp);
                curlist.remove(curlist.size()-1);
            }
        }
    }

    public static void main(String[] args){
        palin_part_i p = new palin_part_i();
        ArrayList<ArrayList<String>> ret = p.partition("aab");
        for(int i = 0;i<ret.size();i++){
            for(int j = 0;j<ret.get(i).size();j++){
                System.out.print(ret.get(i).get(j));
                System.out.print(";");
            }
            System.out.println();
        }

    }

}
