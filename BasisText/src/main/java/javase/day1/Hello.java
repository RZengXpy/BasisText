package javase.day1;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/7 9:15
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world");
        try {
            Time time = new Time(1,2,5);
            System.out.println(time);
        }catch (Exception e){
            System.out.println("构造方法有问题");
        }
        Time tt = new Time();
        tt.setHour(1);
        tt.setMinute(-1);
        tt.setSecond(5);
        System.out.println(tt);

    }
}
