import java.util.Stack;

/**
 * Created by Henry on 2014/11/23.
 */
public class minStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    public void push(int x) {
        if(mins.empty()||x<=mins.peek()){
            mins.push(x);
        }
        s.push(x);
    }
    public void pop() {
        if(!s.isEmpty()){}
        {
            if(s.peek().equals(mins.peek())){
                mins.pop();
            }
            s.pop();
        }
    }
    public int top() {
        if(!s.isEmpty())
        {
            return s.peek();
        }
        else return 0;
    }
    public int getMin() {
        if(mins.isEmpty()){
            return 0;
        }
        return mins.peek();
    }
    public static void main(String[] args){
        minStack m = new minStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.print(m.getMin());
        m.pop();
        System.out.print(m.getMin());
        m.pop();
        System.out.print(m.getMin());
    }
}
