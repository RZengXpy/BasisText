package javase.day3;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/9 15:24
 */
public class CollectionQueue {
    public static void main(String[] args) {
        //先进先出队列，根据元素进出确定队头
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        //优先级队列,默认值小的优先级最高
//        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        queue.add(new Integer(40));
        queue.add(new Integer(145));
        queue.add(new Integer(78));
        queue.add(new Integer(7));

        Integer x = queue.remove();
        System.out.println(x);
    }
}
