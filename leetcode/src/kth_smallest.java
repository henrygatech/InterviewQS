import java.util.Arrays;

/**
 * Created by Henry on 2014/12/16.
 */

public class kth_smallest {
    public int findK(int k, int[] num){
        int pind = partition(num);
        if(pind==k-1)
            return num[pind];
        else if(pind<k-1){
            int[] right = Arrays.copyOfRange(num,pind+1,num.length);
            return findK(k-pind-1,right);
        }
        else{
            int[] left = Arrays.copyOfRange(num,0,pind);
            return findK(k,left);
        }
    }

    public int[] quickSort(int[] num){
        if(num.length<=1){
            return num;
        }
        int pivit = partition(num);
        int[] left = Arrays.copyOfRange(num,0,pivit);
        int[] right = Arrays.copyOfRange(num, pivit + 1, num.length);
        left = quickSort(left);
        right = quickSort(right);
        int[] ret = new int[num.length];
        int count = 0;
        for(Integer i :left){
            ret[count++] = i;
        }
        ret[count++] = num[pivit];
        for(Integer i :right){
            ret[count++] = i;
        }
        return ret;
    }

    public int partition(int[] num){
        int pivit = num[0];
        int i = 1;
        int j = num.length-1;
        while(i<j){
            if(num[i]<pivit){
                i++;
                continue;
            }
            if(num[j]>pivit){
                j--;
                continue;
            }
            swap(num,i,j);
            i++;
            j--;
        }
        swap(num,0,i-1);
        return i-1;
    }

    public void swap(int[] num, int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args){
        kth_smallest k = new kth_smallest();
        int[] num = {7,49,5,2,1,9,3};
        //System.out.println(k.findK(4, num));
        num = k.quickSort(num);
        for(int i = 0;i<num.length;i++){
            System.out.println(num[i]);
        }

    }

}
