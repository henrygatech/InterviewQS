package com.company;

/**
 * Created by Henry on 2014/12/25.
 */
public class string_compression {
    public String compress(String str){
        int count = 0;
        StringBuffer ret = new StringBuffer();
        while(count<str.length()){
            int num = 1;
            while(count+1<str.length()&&str.charAt(count)==str.charAt(count+1)){
                num++;
                count++;
            }
            ret.append(str.charAt(count));
            ret.append(num);
            count++;
        }
        return (ret.toString().length()<str.length())?ret.toString():str;
    }

    public static void main(String[] args){
        string_compression s = new string_compression();
        System.out.println(s.compress("aabcccccaaa"));
    }
}
