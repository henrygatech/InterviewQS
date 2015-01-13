import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/11.
 */
public class palin_1 {
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
                else if(j-i>=2&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }

        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        dfs(s,ret,list,dp);
        return ret;
    }

    public void dfs(String s,ArrayList<ArrayList<String>> ret, ArrayList<String> list,boolean[][] dp){
        if(s.length()==0){
            ret.add((ArrayList<String>)list.clone());
            return;
        }
        if(s.length()<0){
            return;
        }

        for(int i = 1;i<=s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(i);
            if(dp[0][i-1]==true){
                list.add(prefix);
                dfs(suffix,ret,list,dp);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args){
        palin_1 p = new palin_1();

        //p.partition("seeslaveidemonstrateyetartsnomedievalsees");
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
