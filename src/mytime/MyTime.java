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
    public void displayTime12(){
        System.out.println(this);
    }
    public void displayTime24(){
        if(this.hours == 12){
           if(this.meridian)
               System.out.printf("%02d:%02d:%02d\n",this.getHours() - this.getHours(),this.getMinutes(),this.getSeconds());
           else
               System.out.printf("%02d:%02d:%02d\n",this.getHours(),this.getMinutes(),this.getSeconds());
        }
        else{
            if(!this.meridian)
                System.out.printf("%02d:%02d:%02d\n",this.getHours() + 12,this.getMinutes(),this.getSeconds());
            else
                System.out.printf("%02d:%02d:%02d\n",this.getHours(),this.getMinutes(),this.getSeconds());
        }
        

        
    }
    public void tickBySecond(){
        this.seconds++;
        if(this.seconds > 59){
            this.seconds = 0;
            tickByMinute();
        }
    }
    public void tickByMinute(){
        this.minutes++;
        if(this.minutes > 59){
            this.minutes = 0;
            tickByHour();
        }
    }
    public void tickByHour(){
        this.hours++;
        if(this.hours == 12)
            this.meridian = !this.meridian;
        else if(this.hours > 12)
            this.hours = 1;
    }
    public void advanceTime(int seconds){
        this.seconds += seconds;
        while(this.seconds > 59){
            this.seconds -= 60;
            tickByMinute();
            if(this.minutes > 59){
                this.minutes = 0;
                tickByHour();
            }
            
        }
    }
    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d %s",this.hours,this.minutes,this.seconds,getMeridian());
    }
    
}
