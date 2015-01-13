/**
 * Created by Henry on 2014/12/20.
 */
public class multiply_strings {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()-1];
        String rev1 = new StringBuilder(num1).reverse().toString();
        String rev2 = new StringBuilder(num2).reverse().toString();
        for(int i = 0;i<rev2.length();i++){
            for(int j = 0;j<rev1.length();j++){
                res[j+i] += (rev1.charAt(j)-'0')*(rev2.charAt(i)-'0');
            }
        }
        String ret = "";
        int carry = 0;
        for(int i = 0;i<res.length;i++){
            int val = (res[i]+carry)%10;
            carry = (res[i]+carry)/10;
            ret = ret+val;
        }
        while(carry>0){
            int val = carry%10;
            carry = carry/10;
            ret = ret+val;
        }
        ret = new StringBuilder(ret).reverse().toString();
        if(ret.equals("0")){
            return ret;
        }
        else{
            while(ret.charAt(0)=='0'&&ret.length()>1){
                ret = ret.substring(1);
            }
            return ret;
        }
    }

    public static void main(String[] args){
        multiply_strings m = new multiply_strings();
        String num1 = "9133";
        String num2 = "0";
        System.out.println(m.multiply(num1, num2));
    }
}
