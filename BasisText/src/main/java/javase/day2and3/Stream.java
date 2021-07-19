package javase.day2and3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/8 10:05
 */
public class Stream {
    public static void main(String[] args) {
        //输出字节流
//        FileOutputStream fso = null;
//        try {
//            fso = new FileOutputStream("e://abc.txt");
//            fso.write(65);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//                try {
//                    if(fso!=null) fso.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
        //输入字节流
        FileInputStream fio = null;
        try {
            fio = new FileInputStream("e://abc.txt");
            int r;
            while((r = fio.read())!=-1){
                System.out.println((char)r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fio.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
