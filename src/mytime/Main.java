/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytime;
import java.lang.*;

/**
 *
 * @author Marlex
 */
public class Main {
    public static void main(String[] args) {
        MyTime t = new MyTime();
        t.setHours(12);
        t.setMinutes(59);
        t.setSeconds(59);
        t.setMeridian(false);
        
        t.displayTime12();
        t.displayTime24();
        System.out.printf("\n");
        
        t.tickBySecond();
        t.displayTime12();
        t.displayTime24();
        System.out.printf("\n");
        
        t.tickByMinute();
        t.displayTime12();
        t.displayTime24();
        System.out.printf("\n");
        
        t.advanceTime(7569);
        t.displayTime12();
        t.displayTime24();
        System.out.printf("\n");
        
        t.advanceTime(32000);
        t.displayTime12();
        t.displayTime24();
    }
}
