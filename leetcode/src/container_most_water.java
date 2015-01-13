/**
 * Created by Henry on 2015/1/6.
 */
public class container_most_water {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int tmp = (right-left);
            maxArea = Math.max(maxArea,tmp*height[left]<height[right]?height[left++]:height[right--]);
        }
        return maxArea;
    }

    public static void main(String[] args){
        container_most_water c = new container_most_water();
        int[] height = {1,2,1};
        c.maxArea(height);
    }
}
