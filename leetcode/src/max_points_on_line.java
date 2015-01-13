import java.util.HashMap;

/**
 * Created by Henry on 2014/12/9.
 */
public class max_points_on_line {


    class Point {
            int x;
            int y;
            Point() { x = 0; y = 0; }
            Point(int a, int b) { x = a; y = b; }
        }

    public int maxPoints(Point[] points) {
        if(points.length==0){
            return 0;
        }
        int max = 0;

        for(int i = 0;i<points.length;i++){
            HashMap<Double,Integer> map = new HashMap<Double,Integer>();
            int maxfori = 0;
            int count = 0;
            for(int j = 0;j<points.length;j++){
                Double slope = 0.0;

                if(j==i){
                    count++;
                    continue;
                }
                else if(points[j].y==points[i].y&&points[i].x==points[j].x){
                    count++;
                    continue;
                }
                else if(Math.abs(points[j].x-points[i].x)==0){
                    slope = Double.MAX_VALUE;
                    if(map.containsKey(slope)){
                        map.put(slope,map.get(slope)+1);
                        maxfori = Math.max(maxfori,map.get(slope));
                    }
                    else{
                        map.put(slope,1);
                        maxfori = Math.max(maxfori,1);
                    }
                }
                else{
                    slope = (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                    if(map.containsKey(slope)){
                        map.put(slope,map.get(slope)+1);
                        maxfori = Math.max(maxfori,map.get(slope));
                    }
                    else{
                        map.put(slope,1);
                        maxfori = Math.max(maxfori,1);
                    }
                }
            }
            max = Math.max(max,maxfori+count);
        }
        return max;
    }


    public static void main(String[] args){
        max_points_on_line m = new max_points_on_line();

        Point[] points = {m.new Point(0,0),m.new Point(-1,-1),m.new Point(2,2)};
        System.out.print(m.maxPoints(points));
    }
}
