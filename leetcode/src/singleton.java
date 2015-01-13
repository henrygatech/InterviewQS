/**
 * Created by Henry on 2014/11/23.
 */
public class singleton {

    private static singleton instance = null;
    private singleton(){

    }

    public static synchronized singleton getInstance(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }

}
