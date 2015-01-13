/**
 * Created by Henry on 2014/12/5.
 */
public class next_perm {
    public void nextPermutation(int[] num) {
        int partition = -1;
        int changenumber = -1;
        for(int i = num.length-1;i>0;i--){
            if(num[i-1]<num[i]){
                partition = i-1;
                break;
            }
        }

        if(partition==-1){
            int left = 0;
            int right = num.length-1;
            reverse(num,left,right);
            return;
        }

        for(int i = num.length-1;i>=0;i--){
            if(num[i]>num[partition]){
                changenumber = i;
                break;
            }
        }

        if(changenumber!=-1){
            swap(num,partition,changenumber);
            reverse(num,partition+1,num.length-1);
        }

    }

    public void reverse(int[] num, int left,int right){

        while(left<right){
            swap(num,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] num, int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args){
        next_perm n = new next_perm();
        int[] num = {5,1,1};
        n.nextPermutation(num);
        for(int i = 0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }
}
