package com.company;

/**
 * Created by Henry on 2014/12/25.
 */
public class unique_char {

    //Implement an algorithm to determine if a string has all unique characters. What
    //if you cannot use additional data structures?

    //time complexity: O(n) space: O(1)
    public boolean allUnique1(String str){
        boolean[] bitmap = new boolean[256];
        for(int i = 0;i<str.length();i++){
            if(bitmap[str.charAt(i)]==true) {
                return false;
            }
        }
        return true;
    }


    //O(n^2) space O(1)
    public boolean allUnique2(String str){
        for(int i = 0;i<str.length();i++){
            for(int j = i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

}
