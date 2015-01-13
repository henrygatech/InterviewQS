/**
 * Created by Henry on 2015/1/12.
 */
public class test {

    public void func(int[][] matrix){
        int N = matrix.length;
        int i = 0;
        for(i = 0;i<N;i++){
            for(int j = 0;j<=i;j++){
                System.out.print(matrix[j][i-j]);
            }
            System.out.println();
        }

        for(i = N;i<N*2-1;i++){
            for(int j = i-N+1;j<N;j++){
                System.out.print(matrix[j][i-j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        int[][] matrix = {{9, 3, 2, 4},
                {8, 6, 1, 2},
                {5, 5, 6, 7},
                {1, 2, 8, 4}};
        test t= new test();
        t.func(matrix);
    }
}
