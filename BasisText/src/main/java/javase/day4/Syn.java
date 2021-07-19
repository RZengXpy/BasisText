package javase.day4;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 10:35
 */
public class Syn {
    public static void main(String[] args) {
        Pay father = new Pay();
        Pay son = new Pay();
        father.setName("father");
        son.setName("son");
        father.start();
        son.start();
        while(father.isAlive()||son.isAlive()) {

        }
        System.out.println(Bank.money);
    }
}
class Bank{
    public  static Integer money = new Integer(5000);
}
class Pay extends Thread{
    @Override
    public void run() {

        try {
            synchronized (Bank.money){
                int m = Bank.money;
                m=m-3000;
                Thread t = Thread.currentThread();
                System.out.println(t.getName()+"花了3000");
                Thread.sleep(100);
                Bank.money=m;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}