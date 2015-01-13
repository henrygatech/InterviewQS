import java.util.Arrays;

/**
 * Created by Henry on 2014/12/1.
 */
public class merge_sort {
    public int[] mergeSort(int[] num){
        if(num.length==0)
            return num;
        if(num.length==1)
            return num;
        int mid = num.length/2;
        int[] left = Arrays.copyOfRange(num,0,mid);
        int[] right = Arrays.copyOfRange(num, mid, num.length);
        left = mergeSort(left);
        right = mergeSort(right);
        int[] ret = merge(left,right);
        return ret;
    }

    public int[] merge(int[] num1,int[] num2){
        int m = num1.length;
        int n = num2.length;
        int[] ret = new int[m+n];
        int i = 0,j = 0,count = 0;
        while(i<m&&j<n){
            ret[count++] = num1[i]<num2[j]?num1[i++]:num2[j++];
        }
        while(i<m){
            ret[count++] = num1[i++];
        }
        while(j<n){
            ret[count++] = num2[j++];
        }
        return ret;
    }

    public static void main(String[] args){
        merge_sort m = new merge_sort();
        int[] A = {1,0};
        A = m.mergeSort(A);
        for(Integer i :A)
            System.out.println(i);
    }


}
