/**
 * Created by Henry on 2014/11/19.
 */
public class word_search {

    public boolean exist(char[][] board, String word) {


        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(dfs(board,i,j,word,1,visited))
                        return true;

                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board,int i, int j, String word, int ind,boolean[][] visited){
        int m = board.length;
        int n = board[0].length;
        if(ind==word.length()){

            return true;
        }

        if(i<0||j<0){
            return false;
        }

        if(i>=m||j>=n){
            return false;
        }


        //go up
        if(i>1&&word.charAt(ind)==board[i-1][j]&&visited[i-1][j]!=true){
            visited[i-1][j] = true;
            if(dfs(board,i-1,j,word,ind+1,visited))
                return true;
            visited[i-1][j] = false;
        }

        //go down
        if(i<m-1&&word.charAt(ind)==board[i+1][j]&&visited[i+1][j]!=true){
            visited[i+1][j] = true;
            if(dfs(board,i+1,j,word,ind+1,visited))
                return true;
            visited[i+1][j] = false;
        }
        //go left
        if(j>1&&word.charAt(ind)==board[i][j-1]&&visited[i][j-1]!=true){
            visited[i][j-1] = true;
            if(dfs(board,i,j-1,word,ind+1,visited))
                return true;
            visited[i][j-1] = false;
        }
        //go right
        if(j<n-1&&word.charAt(ind)==board[i][j+1]&&visited[i][j+1]!=true){
            visited[i][j+1] = true;
            if(dfs(board,i,j+1,word,ind+1,visited))
                return true;
            visited[i][j+1] = false;
        }

        return false;
    }

    public static void main(String[] args){
        word_search w = new word_search();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        System.out.print(w.exist(board, "ABCB"));

    }
}
