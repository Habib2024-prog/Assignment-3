package NotificationandRemainder.date;

import ExceptionHandling.RpmsErrorHandling;

public class CustomDate{
    private int year;
    private int month;
    private int day;
    private int hour;
    public CustomDate(int year,int month,int day,int hour)throws RpmsErrorHandling{
        if(setYear(year)==0)throw new RpmsErrorHandling("Year must be the valid(Current year) type int "); 
        if(setmonth(month)==0)throw new RpmsErrorHandling("month must be the valid (0<mocnt<=12)  type int");
        if(setday(day)==0)throw new RpmsErrorHandling("day must be the valid(0<day<=31) type int ");
        if(setHour(hour)==0)throw new RpmsErrorHandling("hour must be the valid ");
        this.year=setYear(year);
        this.month=setmonth(month);
        this.day=setday(day);
        this.hour=setHour(hour);
    }

    public int getyear(){return year;}
    public int getmonth(){return month;}
    public int getday(){return day;}
    public int gethour(){return hour;}

    public int setYear(int year){
        return(year>2024&&year<2026)? year:0; 
    }
    public int setmonth(int month){
        return month=(month>0&&month<13)? month:0; 
    }
    public int setday(int day){
        return(day>0&&day<32)? day:0; 
    }
    public int setHour(int hour){
        return(hour<=23&&hour>=0)? hour:0;
    }
    public String toString(){
        return getyear()+"-"+getmonth()+"-"+getday()+":"+((gethour()<=12)?(gethour()+".AM"):(gethour()%12+".PM"));
    }
   












}