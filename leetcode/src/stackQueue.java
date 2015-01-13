import java.util.Stack;

/**
 * Created by Henry on 2014/12/7.
 */
public class stackQueue {

    Stack<Integer> s = new Stack<Integer>();

    public void enqueue(int x){
        s.push(x);
    }

    public int dequeue(){
        if(s.size()==1){
            return s.pop();
        }
        else if(s.size()>1) {
            int tmp = s.pop();
            int ret = dequeue();
            s.push(tmp);
            return ret;
        }
        else
        return -1;

    }

    public static void main(String[] args){
        stackQueue s =  new stackQueue();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        s.enqueue(4);
        System.out.print(s.dequeue());
        System.out.print(s.dequeue());
        System.out.print(s.dequeue());
        System.out.print(s.dequeue());

    }

}
