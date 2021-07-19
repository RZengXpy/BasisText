package javase.day4;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 15:19
 */
public class SynBank {
    public static void main(String[] args) {
        Thread father = new Father();
        Thread son = new Son();
        father.start();
        son.start();
    }
}

class Bank1 {
    public static Integer money = 5000;
}

class Father extends Thread {
    public static Integer money;

    @Override
    public void run() {
        int m = 3000;
        try {
            while (true) {
                Thread.sleep(1000);
                synchronized (Bank1.money) {
                    Bank1.money += m;
//                    if(Bank1.money > 6000) Bank1.money.notify();
                }
                System.out.println("当前余额为：" + Bank1.money);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Thread {
    int m = 1000;

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(200);
                synchronized (Bank1.money) {
                    try {
                        if(Bank1.money < 1000){
                            Bank1.money.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Bank1.money -= m;

                }
                System.out.println("当前余额为：" + Bank1.money);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}