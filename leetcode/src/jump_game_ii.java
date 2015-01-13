/**
 * Created by Henry on 2014/11/20.
 */
public class jump_game_ii {
    public int jump(int[] A) {
        int start = 0;
        int end = 0;
        int count = 0;

        while(end<A.length-1){
            for(int i=start;i<=end;i++){
                if(i+A[i]>=A.length-1)
                    return count+1;
                end = Math.max(end,i+A[i]);
            }
            //update ind with max ind
            start++;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        jump_game_ii j = new jump_game_ii();
        int[] A = {1,2,3};
        j.jump(A);
    }
}
