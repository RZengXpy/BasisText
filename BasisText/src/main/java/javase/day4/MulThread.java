package javase.day4;/**
  * @Description: TODO
  * @Author RZeng
  * @date 2021/7/10 8:13
  * @version 1.0
  */
public class MulThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Output1());
        Output2 thread2 = new Output2();
        thread.start();
        thread2.start();
        for (int i=0;i<=100;i++){
            if(i%9==0) System.out.println();
            System.out.print(i+" ");
        }

    }
}
class Output1 implements Runnable{
    @Override
    public void run() {
        for (int i=9000;i<=10000;i++){
            if(i%9==0) System.out.println();
            System.out.print(i+" ");
        }
    }
}
class Output2 extends Thread{
    @Override
    public void run() {
        for (int i=90000;i<=100000;i++){
            if(i%9==0) System.out.println();
            System.out.print(i+" ");
        }
    }
}
