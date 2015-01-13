package com.company;

/**
 * Created by Henry on 2014/12/29.
 */
public class paint_fill {
    /*
    Implement the "paint fill" function that one might see on many image editing
    programs. That is, given a screen (represented by a two-dimensional array of
    colors), a point, and a new color, fill in the surrounding area until the color
    changes from the original color
    */

    enum color{
        black,white,red,blue, green
    }

    public void painFill(color[][] screen, int x, int y, color o, color n){
        if(x<0||y<0||x>=screen.length||y>=screen.length) {
            return;
        }
        if(screen[x][y] == o){
            screen[x][y] = n;
            painFill(screen,x+1,y,o,n);
            painFill(screen,x-1,y,o,n);
            painFill(screen,x,y+1,o,n);
            painFill(screen,x,y-1,o,n);
        }
    }

    public void painFill(color[][] screen, int x, int y,color n){
        painFill(screen,x,y,screen[x][y],n);
    }

    public static void main(String[] args){
        paint_fill p = new paint_fill();
        color[][] screen = new color[5][5];
        for(int i = 0;i<5;i++){
            screen[0][i] = color.black;
        }
        for(int i = 0;i<5;i++){
            screen[4][i] = color.black;
        }
        for(int i = 0;i<5;i++){
            screen[i][0] = color.black;
        }
        for(int i = 0;i<5;i++){
            screen[i][4] = color.black;
        }
        screen[1][1] = color.white;
        screen[1][2] = color.white;
        screen[1][3] = color.red;
        screen[2][1] = color.white;
        screen[2][2] = color.white;
        screen[2][3] = color.red;
        for(int i = 0;i<screen.length;i++){
            for(int j =0;j<screen[0].length;j++){
                System.out.print(screen[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        p.painFill(screen,1,1,color.blue);
        for(int i = 0;i<screen.length;i++){
            for(int j =0;j<screen[0].length;j++){
                System.out.print(screen[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}
