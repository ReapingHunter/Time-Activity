/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytime;
import java.lang.*;
/**
 *
 * @author User
 */
public class MyTime {

    private int hours;
    private int minutes;
    private int seconds;
    private boolean meridian;
    public MyTime(){

    }
    public int getHours(){
        return hours;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public String getMeridian(){
        return (meridian)? "AM":"PM";
    }
    public void setMeridian(boolean meridian){
        this.meridian = meridian;
    }
    public static void displayTime12(MyTime t){
        System.out.printf("%02d:%02d:%02d %s\n",t.getHours(),t.getMinutes(),t.getSeconds(),t.getMeridian());
    }
    public static void displayTime24(MyTime t){
        if(t.hours == 12){
           if(t.meridian)
               System.out.printf("%02d:%02d:%02d\n",t.getHours() - t.getHours(),t.getMinutes(),t.getSeconds());
           else
               System.out.printf("%02d:%02d:%02d\n",t.getHours(),t.getMinutes(),t.getSeconds());
        }
        else{
            if(!t.meridian)
                System.out.printf("%02d:%02d:%02d\n",t.getHours() + 12,t.getMinutes(),t.getSeconds());
            else
                System.out.printf("%02d:%02d:%02d\n",t.getHours(),t.getMinutes(),t.getSeconds());
        }
        

        
    }
    public static void tickBySecond(MyTime t){
        t.seconds++;
        if(t.seconds > 59){
            t.seconds = 0;
            tickByMinute(t);
        }
    }
    public static void tickByMinute(MyTime t){
        t.minutes++;
        if(t.minutes > 59){
            t.minutes = 0;
            tickByHour(t);
        }
    }
    public static void tickByHour(MyTime t){
        t.hours++;
        if(t.hours == 12)
            t.meridian = !t.meridian;
        else if(t.hours > 12)
            t.hours = 1;
    }
    public static void advanceTime(MyTime t, int seconds){
        t.seconds += seconds;
        while(t.seconds > 59){
            t.seconds -= 60;
            tickByMinute(t);
            if(t.minutes > 59){
                t.minutes = 0;
                tickByHour(t);
            }
            
        }
    }
    public static void main(String[] args) {
        MyTime t = new MyTime();
        t.setHours(12);
        t.setMinutes(59);
        t.setSeconds(59);
        t.setMeridian(false);
        
        displayTime12(t);
        displayTime24(t);
        System.out.printf("\n");
        
        tickBySecond(t);
        displayTime12(t);
        displayTime24(t);
        System.out.printf("\n");
        
        tickByMinute(t);
        displayTime12(t);
        displayTime24(t);
        System.out.printf("\n");
        
        advanceTime(t, 7569);
        displayTime12(t);
        displayTime24(t);
        System.out.printf("\n");
        
        advanceTime(t, 32000);
        displayTime12(t);
        displayTime24(t);
    }
    
}
