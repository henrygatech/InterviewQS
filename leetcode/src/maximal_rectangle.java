import java.util.Stack;

/**
 * Created by Henry on 2014/11/21.
 */
public class maximal_rectangle {


    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        if(n==0)
            return 0;
        int maxArea = 0;
        int[][] height = new int[m+1][n];
        for(int i = 0;i<n;i++){
            height[0][i] = 0;
        }


        for(int i = 1;i<m+1;i++){
            for(int j  =0; j<n;j++){
                if(matrix[i-1][j]==0)
                    height[i][j] = 0;
                else{
                    height[i][j] = height[i-1][j]+1;
                }
            }
        }


        for(int i = 1;i<m+1;i++){
            maxArea = Math.max(maxArea,maxAreaInHist(height[i]));
        }

        return maxArea;

    }

    public int maxAreaInHist(int[] height){
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        int maxrec = 0;
        while(i<height.length){
            if(s.isEmpty()||height[i]>height[s.peek()]){
                s.push(i++);
            }
            else{
                int t = s.pop();
                int area = height[t]*(s.isEmpty()?i:i-s.peek()-1);
                maxrec = Math.max(area,maxrec);
            }
        }
        while(!s.isEmpty()){
            int t = s.pop();
            int area = height[t]*(s.isEmpty()?i:i-s.peek()-1);
            maxrec = Math.max(area,maxrec);
        }

        return maxrec;
    }


    public static void main(String[] args){
        maximal_rectangle m = new maximal_rectangle();
        //int[][] rec = {1};
        //m.maximalRectangle(rec);
    }


}
