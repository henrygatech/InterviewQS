package com.company;

/**
 * Created by Henry on 2014/12/25.
 */
public class replace_blank_1_3 {
    /*
    Write a method to replace all spaces in a string with'%20'. You may assume that
    the string has sufficient space at the end of the string to hold the additional
    characters, and that you are given the "true" length of the string. (Note: if implementing
    Input: "Mr John Smith
    Output: "Mr%20Dohn%20Smith"
    */

    public String replace(char[] str){
        int count = str.length-1;
        while(str[count]==' '){
            count--;
        }
        for(int i = str.length-1;i>=0;i--){
            if(str[count]==' '){
                str[i--] = '0';
                str[i--] = '2';
                str[i] = '%';
                count--;
            }
            else{
                str[i] = str[count];
                count--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args){
        replace_blank_1_3 r = new replace_blank_1_3();
        char[] str = "Mr John Smith    ".toCharArray();
        System.out.println(r.replace(str));
    }
}
