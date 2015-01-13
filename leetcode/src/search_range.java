/**
 * Created by Henry on 2014/12/4.
 */
public class search_range {

    public int[] searchRange(int[] A, int target) {
        int start = -1;
        int end = -1;
        for(int i = 0;i<A.length;i++){
            if(A[i]==target){
                start = i;
                end = i;
                int j = i;
                while(j+1<A.length&&A[j]==A[j+1]) j++;
                end = j;
                i = j;
            }
        }
        int[] ret = {start,end};
        return ret;
    }

    public static void main(String[] args){
        search_range s = new search_range();
        int[] num = {2,2};
        System.out.println(s.searchRange(num, 2)[0] +""+ s.searchRange(num, 2)[1]);
    }
}
