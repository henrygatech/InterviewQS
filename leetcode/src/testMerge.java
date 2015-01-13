import java.util.Arrays;

/**
 * Created by Henry on 2014/12/16.
 */
public class testMerge {
    public void sortColors(int[] A) {
        int[] B = mergeSort(A);
        int i = 0;
        while(i<B.length){
            A[i] = B[i];
            i++;
        }
    }

    public int[] mergeSort(int[] A){
        if(A.length<=1){
            return A;
        }
        int mid = A.length/2;
        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A,mid,A.length);
        mergeSort(left);
        mergeSort(right);
        A = merge(left,right);
        return A;
    }

    public int[] merge(int[] left, int[] right){
        int m = left.length-1;
        int n = right.length-1;
        int[] ret = new int[m+n+2];
        while(m>=0&&n>=0){
            if(left[m]>right[n]){
                ret[m+n+1] = left[m--];
            }
            else{
                ret[m+n+1] = right[n--];
            }
        }
        while(m>=0){
            ret[m+n+1] = left[m--];
        }
        while(n>=0){
            ret[m+n+1] = right[n--];
        }
        return ret;
    }
    public static void main(String[] args){
        testMerge t = new testMerge();
        //int[] A = {1,3,5,6};
        //int[] B = {2,4,7};
        int[] ret = {1,0};
        t.sortColors(ret);
        //int[] ret = t.merge(A,B);
        for(int i = 0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }

}
