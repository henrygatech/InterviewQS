/**
 * Created by Henry on 2014/11/17.
 */
public class surroundedArea {
    public void solve(char[][] board) {

        if(board.length==0)
            return;
        if(board[0].length==0)
            return;

        int m = board.length;
        int n = board[0].length;

        //top
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
        }
        //bottom
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'){
                dfs(board,m-1,i);
            }
        }
        //left
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
        }
        //right
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(board,0,i);
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }

        }
    }

    public void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        board[i][j] = '#';
        //try to go up
        if(i>0){
            if(board[i-1][j]=='O'){
                dfs(board,i-1,j);
            }
        }

        //try to go down
        if(i<m-1){
            if(board[i+1][j]=='O'){
                dfs(board,i+1,j);
            }
        }

        //try to go left
        if(j>0){
            if(board[i][j-1]=='O'){
                dfs(board,i,j-1);
            }
        }

        //try to go right
        if(j<n-1){
            if(board[i][j+1]=='O'){
                dfs(board,i,j+1);
            }
        }
    }

    public static void main(String[] args){

        surroundedArea s = new surroundedArea();
        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        s.solve(board);
    }
}
