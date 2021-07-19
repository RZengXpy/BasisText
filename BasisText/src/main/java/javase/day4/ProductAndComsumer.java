package javase.day4;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/10 9:37
 */
public class ProductAndComsumer {
    public static void main(String[] args) {
        Thread product = new Product();
        Thread comsumer = new Comsumer();
        product.start();
        comsumer.start();
    }
}
class Factory{
    public static Integer poistion = 10;
}
class Product extends Thread{
    @Override
    public void run() {
    }
}
class Comsumer extends Thread{
    @Override
    public void run() {
    }
}