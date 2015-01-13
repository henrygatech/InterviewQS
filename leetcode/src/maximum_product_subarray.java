/**
 * Created by Henry on 2014/12/9.
 */
public class maximum_product_subarray {

    public int maxProduct(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ret = Integer.MIN_VALUE;

        for(int i = 0;i<A.length;i++){
            for(int j = i;j<A.length;j++){
                if(j == i){
                    min = A[j];
                    max = A[j];
                }
                else{
                    int tmpmin = Math.min(Math.min(min*A[j],max*A[j]),A[j]);
                    int tmpmax = Math.max(Math.max(min*A[j],max*A[j]),A[j]);
                    min = tmpmin;
                    max = tmpmax;
                    ret = Math.max(max,ret);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        maximum_product_subarray m = new maximum_product_subarray();
        int[] A = {2,3,-2,4};
        System.out.println(m.maxProduct(A));
    }

}
