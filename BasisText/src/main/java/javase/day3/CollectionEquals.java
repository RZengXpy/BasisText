//package day3;
//
//import java.util.ArrayList;
//
///**
// * @version 1.0
// * @Description: TODO
// * @Author RZeng
// * @date 2021/7/9 16:02
// */
//public class CollectionEquals {
//    public static void main(String[] args) {
//        ArrayList<Time> arrayList = new ArrayList<>();
//        arrayList.add(new Time(15,10,0));
//        boolean flag = arrayList.contains(new Time(15,10,0));
//        System.out.println(flag);
//    }
//}
//class Time{
//    private int hour ,minute , second;
//    public Time(int h,int m , int s){
//        hour = h;
//        minute = m;
//        second = s;
//    }
//    //注释掉equals方法，只能判断同一对象
//    @Override
//    public boolean equals(Object obj){
//        if(obj==null) return false;
//        if(obj instanceof  Time){
//            Time t = (Time) obj;
//            return hour ==t.hour&& minute == t.minute && second == t.second;
//        }
//        return false;
//    }
//}
