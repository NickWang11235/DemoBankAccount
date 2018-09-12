/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.Util;

/**
 *
 * @author nickw
 */
public class Date implements Comparable<Date>{

    
    public enum Month{
        JAN(1),
        FEB(2),
        MAR(3),
        APR(4),
        MAY(5),
        JUN(6),
        JUL(7),
        AUG(8),
        SEP(9),
        OCT(10),
        NOV(11),
        DEC(12);
        
        private int month;
        
        Month(int month){
            this.month = month;
        }
        
        public int getNumMonth(){
            return month;
        }
        
    }
    
    
    private final int year, day;
    private Month month; 

    public Date(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
    @Override
    public int compareTo(Date o) {
        return year-o.year*1000 + month.compareTo(o.month)*100 + day-o.day;
    }
 
    @Override
    public String toString(){
        return month.getNumMonth() + "/" + day + "/" + year;
    }
}
