/**
 * Created by Henry on 2014/12/20.
 */
public class jump_game2 {
    public int jump(int[] A) {
        if(A.length==0)
            return 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while(right<A.length-1){
            int possibleRight = right;
            for(int i = left;i<=right;i++){
                possibleRight = Math.max(possibleRight,i+A[i]);
            }

            count++;
            left++;
            right = possibleRight;
        }
        return count;
    }
    public static void main(String[] args){
        jump_game2 j = new jump_game2();
        int[] A = {2,3,0,1,4};
        j.jump(A);
    }
}
