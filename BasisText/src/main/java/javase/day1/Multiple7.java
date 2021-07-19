package javase.day1;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/7 9:19
 */
public class Multiple7 {
    public static void main(String[] args) {
        for (int i = 7; i < 101; i++) {
            if (i % 7 == 0 || i % 10 == 7 || (i / 10 == 7)) System.out.print(i + "\t");
        }
    }
}
