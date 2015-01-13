import java.util.Stack;

/**
 * Created by Henry on 2014/12/26.
 */

public class myQueue {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> buffer = new Stack<Integer>();

    public void enQueue(int val){
        s.push(val);
    }

    //using two stacks
/*    public int deQueue(){
        if(s.isEmpty()){
            return -1;
        }
        else{
            while(!s.isEmpty()){
                buffer.push(s.pop());
            }
            int tmp =  buffer.pop();
            while(!buffer.isEmpty()){
                s.push(buffer.pop());
            }
            return tmp;
        }
    }*/

    public int deQueue(){
        if(s.isEmpty()){
            return -1;
        }
        else{
            int tmp = s.pop();
            if(s.isEmpty()){
                return tmp;
            }
            int ret = deQueue();
            s.push(tmp);
            return ret;
        }
    }

    public static void main(String[] args){
        myQueue m = new myQueue();
        m.enQueue(1);
        m.enQueue(2);
        m.enQueue(3);
        System.out.println(m.deQueue());
        System.out.println(m.deQueue());
    }

}
