/**
 * Created by Henry on 2014/11/21.
 */
public class next_permutation {

    public void nextPermutation(int[] num) {

        int iind = -1;
        int jind = -1;
        int kind = -1;

        for(int i = 0;i<num.length-1;i++){
            if(num[i]<num[i+1]){
                iind = i;
                jind = i+1;
            }
        }

        if(iind==-1&&jind==-1){
            //return ascending
            for(int i = 0;i<num.length/2;i++){
                swap(num,i,num.length-1-i);
            }
            return;
        }

        for(int j = num.length-1;j>=0;j--){
            if(num[j]>num[iind]){
                swap(num,j,iind);
                int cur = 0;
                for(int i = jind;i<(num.length-jind)/2;i++){
                    swap(num,i,num.length-1-cur);
                    cur++;
                }
            }
        }

    }

    public void swap(int[] num, int i, int j){
        int tmp = num[j];
        num[j] = tmp;
        num[i] = num[j];
    }


}
