package javase.day3;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 17:14
 */
public class InnerClass {
    public static void main(String[] args) {
        Outter outter = new Outter();
        InnerInterface inner = outter.getClassInner();
        inner.fun();
        System.out.println(outter.a);
        System.out.println(outter.b);
    }

}

interface InnerInterface{
    void fun();
}
class Outter{
    public int a=50,b=51;
    public Inner getClassInner(){
        return new Inner();
    }
    private class Inner implements InnerInterface{
        public int a=49,b=48,c,d;
        public void fun(){
            Outter.this.a=1;
            Outter.this.b=2;
            c=3;
            d=4;
            System.out.println(a+" "+b+" "+c+" "+d+" "+Outter.this.a+" "+Outter.this.b);
        }
    }
}
