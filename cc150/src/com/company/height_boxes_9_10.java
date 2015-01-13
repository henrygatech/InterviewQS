package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Henry on 2014/12/29.
 */
class Box{
    int height;
    int width;
    int depth;

    public boolean greaterThan(Box b){

        if(this.height>b.height&&this.depth>b.depth&&this.width>b.width){
            return true;
        }
        else return false;
    }

    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public String toString(){
        return "height "+height+", width "+width+", depth"+depth;
    }
}

public class height_boxes_9_10 {

    public int getHeight(ArrayList<Box> boxs){
        int sum = 0;
        for(Box b :boxs){
            sum+=b.height;
        }
        return sum;
    }

    public ArrayList<Box> helper(Box cur,ArrayList<Box> list){
        ArrayList<Box> maxList = null;
        int max = 0;
        for(int i = 0;i<list.size();i++){
            if(cur!=null&&cur.greaterThan(list.get(i))){
                Box tmp = list.get(i);
                list.remove(i);
                ArrayList res = helper(tmp,list);
                int up = getHeight(res);
                if(up>max){
                    max = up;
                    maxList = res;
                }
                list.add(tmp);
            }
            else{
                Box tmp = list.get(i);
                list.remove(i);
                ArrayList res = helper(tmp,list);
                int up = getHeight(res);
                if(up>max){
                    max = up;
                    maxList = res;
                }
                list.add(tmp);
            }
        }
        if(maxList==null){
            maxList = new ArrayList<Box>();
        }
        if(cur==null){
            return maxList;
        }
        else {
            maxList.add(cur);
            return maxList;
        }
    }

    public ArrayList<Box> helperDP(Box cur,ArrayList<Box> list, HashMap<Box,ArrayList<Box>> map){
        if(cur!=null&&map.containsKey(cur)){
            return map.get(cur);
        }
        int max = 0;
        ArrayList<Box> ret = null;
        for(int i = 0;i<list.size();i++){
            if(cur!=null&&cur.greaterThan(list.get(i))) {
                Box tmp = list.get(i);
                ArrayList<Box> res = helperDP(tmp,list,map);
                int height = getHeight(res);
                if(height>max){
                    max = height;
                    ret = res;
                }
            }
            if(cur==null){
                Box tmp = list.get(i);
                ArrayList<Box> res = helperDP(tmp,list,map);
                int height = getHeight(res);
                if(height>max){
                    max = height;
                    ret = res;
                }
            }
        }
        if(ret==null){
            ret = new ArrayList<Box>();
        }
        if(cur==null){
            return ret;
        }
        else{
            ret.add(0,cur);
            map.put(cur, ret);
            return ret;
        }

    }


    public static void main(String[] args){
        height_boxes_9_10 h = new height_boxes_9_10();
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(3, 4, 1));
        boxes.add(new Box(8, 6, 2));
        boxes.add(new Box(7, 8, 3));
        HashMap<Box,ArrayList<Box>> map = new  HashMap<Box,ArrayList<Box>>();
        ArrayList<Box> stack = h.helperDP(null, boxes,map);
        for (int i = stack.size() - 1; i >= 0; i--) {
            Box b = stack.get(i);
            System.out.println(b.toString());
        }
    }

}
