package javase.day1;

import java.util.Objects;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/7 9:36
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
    }

    public Time(int hour, int minute, int second) throws Exception{
        if (hour >= 0 && hour <= 24)
            this.hour = hour;
        else throw new Exception();

        if (minute >= 0 && minute <= 59)
            this.minute = minute;
        else throw new Exception();

        if (second >= 0 && second <= 59)
            this.second = second;
        else throw new Exception();

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        try{
            if (hour >= 0 && hour <= 24)
                this.hour = hour;
            else throw new Exception();
        }catch (Exception e){
            System.out.println("hour error 小时错误");
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        try{
        if (minute >= 0 && minute <= 59)
            this.minute = minute;
        else throw new Exception();
        }catch (Exception e){
            System.out.println("minute error 分错误");
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        try{
            if (second >= 0 && second <= 59)
                this.second = second;
            else throw new Exception();
        }catch (Exception e){
            System.out.println("second error 秒错误");
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
    //自己写的
//    @Override
//    public boolean equals(Object obj){
//        //5
//        if(obj==null) return false;
//        //判断引用类型是否为Time
//        if(obj instanceof Time){
//            Time t = (Time)obj;
//            return (this.hour == t.hour)&&(this.minute == t.minute)&&( this.second == t.second);
//        }
//        return false;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute && second == time.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

}
