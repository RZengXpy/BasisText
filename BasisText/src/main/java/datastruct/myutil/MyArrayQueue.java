package datastruct.myutil;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/19 8:28
 */

public class MyArrayQueue<E> implements MyQueue<E>, Iterable<E> {
    /**
     * 数组首地址
     */
    private Object[] elem;
    /**
     * 数组的元素的数量
     */
    private int front, rear;
    /**
     * 数组的最大长度
     */
    private int maxSize = 10;

    /**
     * 构造函数，初始化数组
     */
    public MyArrayQueue() {
        elem = new Object[maxSize];
        front = rear = 0;
    }

    @Override
    public E peek() {
        if (rear == front) return null;

        return (E) elem[front];
    }

    @Override
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) return null;
        E e = (E) elem[front];
        front = (front + 1) % maxSize;
        return e;
    }

    @Override
    public boolean enQueue(E e) {
        if ((rear + 1) % maxSize == front) return false;
        elem[rear] = e;
        rear = (rear + 1) % maxSize;
        return true;
    }

    @Override
    public void clear() {
        front = rear = 0;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    private class Itr<E> implements Iterator<E> {
        int nextElem = front;

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }

        @Override
        public boolean hasNext() {
            return front != rear;
        }

        @Override
        public E next() {
            if (isEmpty()) return null;
            return (E) elem[(nextElem++) % maxSize];
        }
    }


}
