import java.util.ArrayList;

/**
 * Created by Henry on 2014/12/12.
 */
public class pascal_triangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(numRows==0){
            return ret;
        }
        ret.add(new ArrayList<Integer>());
        ret.get(0).add(1);
        for(int i = 1;i<numRows;i++){
            if(ret.size()==i){
                ret.add(new ArrayList<Integer>());
                for(int j = 0;j<i;j++){
                    if(j==0){
                        ret.get(i).add(ret.get(i-1).get(j));
                    }
                    else if(j==i){
                        ret.get(i).add(ret.get(i-1).get(j-1));
                    }
                    else{
                        ret.get(i).add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                    }
                }
            }
        }

        return ret;
    }


}
