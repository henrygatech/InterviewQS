/**
 * Created by Henry on 2015/1/3.
 */
public class search_2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length-1;
        while(top<=bottom){
            int mid = (top+bottom)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if(matrix[mid][0]<target){
                top = mid+1;
            }
            else{
                bottom = mid-1;
            }
        }
        if(bottom>=0&&bottom<matrix.length){
            return binarySearch(matrix[bottom],target);
        }
        else return false;
    }

    public boolean binarySearch(int[] A,int target){
        int left = 0;
        int right = A.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]==target){
                return true;
            }
            else if(A[mid]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        search_2D s = new search_2D();
        int[][] a = {{1}};
        s.searchMatrix(a,2);
    }
}
