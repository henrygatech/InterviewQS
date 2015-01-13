import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Henry on 2014/12/11.
 */
public class surrounded_area {

    public void solve(char[][] board) {
        int m = board.length;
        if(m==0){
            return;
        }
        int n = board[0].length;
        if(n==0){
            return;
        }
        boolean[][] visited = new boolean[m][n];
        //top
        for(int i = 0;i<n;i++){
            if(board[0][i]=='O'){
                bfs(board,0,i,visited);
            }
        }

        //down
        for(int i = 0;i<n;i++){
            if(board[m-1][i]=='O'){
                bfs(board,m-1,i,visited);
            }
        }

        //left
        for(int i = 1;i<m-1;i++){
            if(board[i][0]=='O'){
                bfs(board,i,0,visited);
            }
        }

        //right
        for(int i = 1;i<m-1;i++){
            if(board[i][n-1]=='O'){
                bfs(board,i,n-1,visited);
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }

    }

    public void bfs(char[][] board, int i, int j, boolean[][] visited){

        int m = board.length;
        if(m==0){
            return;
        }
        int n = board[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i*(n)+j);
        while(!q.isEmpty()){
            int tmp = q.poll();
            int row = tmp/n;
            int col = tmp%n;
            //visit row col
            board[row][col] = '#';
            visited[row][col] = false;
            //up
            if(row>0&&visited[row-1][col]==false&&board[row-1][col]=='O'){
                q.offer((row-1)*n+col);
            }
            //down
            if(row<m-1&&visited[row+1][col]==false&&board[row+1][col]=='O'){
                q.offer((row+1)*n+col);
            }
            //left
            if(col>0&&visited[row][col-1]==false&&board[row][col-1]=='O'){
                q.offer(row*n+col-1);
            }
            //right
            if(col<n-1&&visited[row][col+1]==false&&board[row][col+1]=='O'){
                q.offer(row*n+col+1);
            }
        }
    }

    public static void main(String[] args){

        surrounded_area s = new surrounded_area();
        //char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        char[][] board = {{}};

        s.solve(board);
    }

}
