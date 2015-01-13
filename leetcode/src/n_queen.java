import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/20.
 */
public class n_queen {

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<String[]> ret = new ArrayList<String[]>();
        dfs(n,0,cols,ret);
        return ret;
    }

    public void dfs(int n, int cur, ArrayList<Integer> cols, ArrayList<String[]> ret){
        if(cols.size()==n){
            //add a new string[]
            String[] strs = new String[n];
            for(int i = 0;i<cols.size();i++){
                String str = "";
                for(int j = 0;j<n;j++){
                    if(j!=cols.get(i)){
                        str = str+".";
                    }
                    else{
                        str = str+"Q";
                    }
                }
                strs[i] = str;
            }
            ret.add(strs);
        }
        for(int i = 0;i<n;i++){
            if(check(cols,cur,i)){
                cols.add(i);
                dfs(n,cur+1,cols,ret);
                cols.remove(cols.size()-1);
            }
        }
    }

    public boolean check(ArrayList<Integer> cols, int row, int col){
        for(int i = 0;i<row;i++){
            if(cols.get(i)==col){
                return false;
            }
            if(Math.abs((cols.get(i)-col)/(i-row))==1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        n_queen n = new n_queen();
        n.solveNQueens(4);
        ArrayList<String[]> ret = n.solveNQueens(4);
        for(String[] strs:ret){
            for(String tmp:strs){
                System.out.println(tmp);
            }
            System.out.println();
            System.out.println();
        }
    }

}
