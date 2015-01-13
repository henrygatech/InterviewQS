/**
 * Created by Henry on 2014/12/21.
 */
public class first_missing_positive {

    public int firstMissingPositive(int[] A) {
        for(int i = 0;i<A.length;i++){
            if(A[i]>0&&A[i]<A.length&&A[i]!=i+1){
                swap(A,i,A[i]-1);
                i--;
            }
        }
        for(int i = 0;i<A.length;i++){
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return A.length;
    }

    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args){
        first_missing_positive f =  new first_missing_positive();
        int[] A = {1,0};
        System.out.print(f.firstMissingPositive(A));
    }
}
