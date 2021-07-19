package datastruct.main;

import datastruct.myutil.MyArrayList;
import datastruct.myutil.MyLinkedList;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/19 9:11
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyLinkedList<Integer> myLinkedList =new MyLinkedList<>();
        myLinkedList.insert(0,5);
        System.out.println(myLinkedList.get(0));
    }
}
