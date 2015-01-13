import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/3.
 */
public class n_queens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret  = new ArrayList<String[]>();
        ArrayList<Integer> colForRows = new ArrayList<Integer>();
        if(n==0){
            return ret;
        }
        else{
            helper(n,0,colForRows,ret);
        }

        return ret;
    }

    public void helper(int n,int row,ArrayList<Integer> colForRows, ArrayList<String[]> ret){
        if(row==n){
            //generate the string[]
            String[] strs = new String[n];
            for(int i  = 0; i<n;i++){
                strs[i] = new String();
                for(int j = 0;j<n;j++){

                    if(j!=colForRows.get(i))
                        strs[i] += ".";
                    else{
                        strs[i] += "Q";
                    }
                }
            }
            ret.add(strs);
            return;
        }
        for(int i = 0;i<n;i++){
            if(check(row,i,colForRows)){
                colForRows.add(i);
                helper(n,row+1,colForRows,ret);
                colForRows.remove(colForRows.size()-1);
            }
        }
    }

    public boolean check(int row, int col, ArrayList<Integer> colForRows){
        for(Integer c : colForRows){
            if(c==col){
                return false;
            }
        }
        return true;
    }
    public static  void main(String[] args){
        n_queens n = new n_queens();
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
