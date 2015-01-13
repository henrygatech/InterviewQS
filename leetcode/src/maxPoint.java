import java.util.HashMap;

/**
 * Created by Henry on 2014/11/17.
 */
class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
}

public class maxPoint {

    public int maxPoints(Point[] points) {
        if(points.length<=1)
            return points.length;

        int maxpoints = 0;

        for(int i=0;i<points.length;i++){
            HashMap<Float,Integer> map = new HashMap<Float,Integer>();
            int curCount = 0;
            int dup = 0;
            for(int j=0;j<points.length;j++){

                //for point i
                if(j!=i){
                    float slope = 0.0000f;
                    if(points[j].x==points[i].x&&points[j].y==points[i].y){
                        dup++;
                        continue;
                    }
                    else if(points[j].x==points[i].x){
                        slope = Float.MAX_VALUE;
                    }
                    else slope =((float)points[j].y-(float)points[i].y)/((float)points[j].x-(float)points[i].x);

                    if(map.containsKey(slope))
                        map.put(slope,map.get(slope)+1);
                    else{
                        map.put(slope,1);
                    }
                }
            }
            curCount=1+dup;
            maxpoints = Math.max(curCount,maxpoints);
            for(Float ind:map.keySet()){
                maxpoints = Math.max(maxpoints,curCount+map.get(ind));
            }
        }
        return maxpoints;

    }

    public static void main(String[] args){
        maxPoint m = new maxPoint();
        Point[] points = new Point[9];
        points[0] = new Point(84,250);
        points[1] = new Point(0,0);
        points[2] = new Point(1,0);
        points[3] = new Point(0,-70);
        points[4] = new Point(0,-70);
        points[5] = new Point(1,-1);
        points[6] = new Point(21,10);
        points[7] = new Point(42,90);
        points[8] = new Point(-42,-230);
        //m.maxPoints();
        System.out.print(m.maxPoints(points));
    }



}
