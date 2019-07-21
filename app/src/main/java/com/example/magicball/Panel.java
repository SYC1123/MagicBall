package com.example.magicball;

import android.view.View;

public class Panel{
    private View mView;

    final static double spf=0.03;
    final static int width=80;
    final static int height=80;
    static int max_width=700-width;
    static int max_height=700-height;

    public static double speed_x=130;
    public static double speed_y=200;
    public static double acceleration_y=100;
    public double x=30,y=500;

    public Panel(View mView) {
        this.mView = mView;
    }

    public void paint() {
        if(y<max_height-10)
            speed_y+=acceleration_y;
        else if(Math.abs(speed_y)<30){
            if(speed_x>5)
                speed_x-=10;
            else if(speed_x<-5)
                speed_x+=10;
            else
                speed_x=0;
        }
        x+=speed_x*spf;
        y+=speed_y*spf;
        if((x>max_width||x<0)&&(int)speed_x!=0) {
            if(x>max_width) {
                x=max_width-1;
                speed_x-=30;
            }
            else {
                x=1;
                speed_x+=30;
            }
            speed_x=-speed_x;
            if(Math.abs(speed_x)<30)
                speed_x=0;
        }
        if((y>max_height||y<0)&&(int)speed_y!=0) {
            if(y>max_height) {
                y=max_height-1;
                speed_y-=200;
            }
            else {
                y=1;
                speed_y+=200;
            }
            speed_y=-speed_y;
            if(Math.abs(speed_y)<200)
                speed_y=0;
        }

        ((MyCanvas)mView).preDraw(x,y);

        System.out.println(speed_x+"   "+speed_y+"   x "+x+"    y "+y);
    }

}