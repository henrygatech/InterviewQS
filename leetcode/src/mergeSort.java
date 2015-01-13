/**
 * Created by Henry on 2014/11/16.
 */
public class mergeSort {

    public void mergeSort(int[] A,int left, int right){

        if(left<right){
            int mid = (left+right)/2;
            mergeSort(A,left,mid);
            mergeSort(A,mid+1,right);
            merge(A,left,mid,mid+1,right);
        }

    }

    public void merge(int[] A,int left1,int right1, int left2,int right2){
        int[] helper = new int[right2-left1+1];
        int start = left1;
        int ind = 0;
        while(left1<=right1&&left2<=right2){
            if(A[left1]<A[left2]){
                helper[ind++] = A[left1++];
            }
            else{
                helper[ind++] = A[left2++];
            }
        }
        while(left1<=right1){//1 still remains
            helper[ind++] = A[left1++];
        }
        while(left2<=right2){//1 still remains
            helper[ind++] = A[left2++];
        }
        int count = 0;
        while(start<=right2) {
            A[start++] = helper[count++];
        }

    }

    public static void main(String[] args){
        mergeSort m = new mergeSort();
        int[] A = {2,4,7,3,1,5};
        m.mergeSort(A,0,A.length-1);
        for(Integer i :A)
        System.out.println(i);
    }


}
