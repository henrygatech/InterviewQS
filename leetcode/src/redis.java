import java.util.HashMap;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class redis {
    private ArrayList<String> commands;
    private HashMap<String, String> map;
    private HashMap<String, Integer> valmap;
    private Stack<String> transactions;
    private boolean rollingBack;

    public void readCommand(){
        try{

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String input;

            while((input=br.readLine())!=null){
                //commands.add(input);
                if(input.equalsIgnoreCase("end"))
                    break;
                else
                excuteCommand(input);
            }


        }catch(IOException io){

            io.printStackTrace();

        }
    }


    public redis(){
        commands = new ArrayList<String>();
        map = new HashMap<String,String>();
        valmap = new HashMap<String,Integer>();
        transactions = new Stack<String>();
        readCommand();
    }

    public void set(String k,String v){
        String preVal = map.get(k);
        map.put(k, v);
        if(valmap.containsKey(v)){
            valmap.put(v,valmap.get(v)+1);
        }
        else{
            valmap.put(v,1);
        }
        if(!rollingBack){
            updateTransactionsAfterSet(k,preVal);
        }
    }

    public String get(String k){
        return map.get(k);
    }


    public int numequalto(String v){
        return (valmap.get(v)==null)?0:valmap.get(v);
    }

    public void unset(String k){

        if(valmap.containsKey(map.get(k))){
            valmap.put(map.get(k),valmap.get(map.get(k))-1);
        }
        String value = map.get(k);
        map.remove(k);
        if(!rollingBack){
            updateTransactionsAfterUnset(k,value);
        }
    }

    public void begin(){
        transactions.push(null);
    }

    public void rollback(){
        if(transactions.isEmpty()){
            System.out.println("No Transcation");
        }
        else{
            rollingBack = true;
            while(transactions.peek()!=null){
                String command = transactions.pop();
                excuteCommand(command);
            }
            transactions.pop();
            rollingBack = false;
        }
    }

    public void excuteCommand(String command){
        String[] strs = command.split(" ");
        if(strs[0].equalsIgnoreCase("set")){
            set(strs[1],strs[2]);
        }
        else if (strs[0].equalsIgnoreCase("get")){
            System.out.println( " -> "+ get(strs[1]));
        }
        else if (strs[0].equalsIgnoreCase("unset")){
            unset(strs[1]);
        }
        else if (strs[0].equalsIgnoreCase("numequalto")){
            System.out.println( " -> "+ numequalto(strs[1]));
        }
        else if (strs[0].equalsIgnoreCase("begin")){
            begin();
        }
        else if (strs[0].equalsIgnoreCase("commit")){
            commit();
        }
        else if (strs[0].equalsIgnoreCase("rollback")){
            rollback();
        }
    }

    public void updateTransactionsAfterSet(String key, String value){
        String command;
        //if a block exists
        if (!transactions.isEmpty()){
            if (value == null){
                //previous key did not exist so unset during rollback
                command = "unset" +" "+key;
            } else {
                //previous key did exist so set previous value during rollback
                command = "set" + " " + key + " " + value;
            }
            transactions.push(command);
        }
    }

    void updateTransactionsAfterUnset(String key, String value){
        //if a block exists
        if (!transactions.isEmpty()){
            //set previous key and value during rollback
            String command = "set" + " " + key + " " + value;
            transactions.push(command);
        }
    }


    public void commit(){
        if (transactions.isEmpty()){
            System.out.println("No transaction pending");
        } else {
            //a commit clears all transactions in the stack
            transactions.clear();
        }
    }

    public static void main(String[] args){
        redis d = new redis();
    }

}
