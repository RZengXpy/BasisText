package javase.day3;

import java.util.HashMap;
import java.util.Objects;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 16:42
 */
public class CollectionMap {
    public static void main(String[] args) {
//        HashMap<String , Integer> hashMap = new HashMap<>();
//        hashMap.put("广东省",new Integer(1));
//        hashMap.put("湛江市",new Integer(2));
//        hashMap.put("赤坎区",new Integer(3));
//
//        Integer x = hashMap.get("赤坎区");
//        System.out.println(x);
//
//        x = hashMap.get("赤区");
//        System.out.println(x);

        HashMap<Time , Integer> hashMap = new HashMap<>();
        hashMap.put(new Time(15,10,1),new Integer(1));
        hashMap.put(new Time(15,0,1),new Integer(2));
        hashMap.put(new Time(15,20,1),new Integer(3));

        Integer x = hashMap.get(new Time(15,10,1));
        System.out.println(x);

        x = hashMap.get("赤区");
        System.out.println(x);

    }
}
class Time{
    private int hour ,minute , second;
    public Time(int h,int m , int s){
        hour = h;
        minute = m;
        second = s;
    }
    //注释掉equals方法，只能判断同一对象
    @Override
    public boolean equals(Object obj){
        if(obj==null) return false;
        if(obj instanceof  Time){
            Time t = (Time) obj;
            return hour ==t.hour&& minute == t.minute && second == t.second;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }
}