package datastruct.myutil;

import java.util.Iterator;
import java.util.function.Consumer;


/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/20 14:43
 */
public class MyArrayStack<E> implements MyStack<E>,Iterable<E>{
    /**
     * 数组首地址
     */
    private Object[] elem;
    /**
     * 数组的元素的数量
     */
    private int size;
    /**
     * 数组的最大长度
     */
    private int maxSize = 10;

    /**
     * 构造函数，初始化数组
     */
    public MyArrayStack() {
        elem = new Object[maxSize];
        size = 0;
    }

    private void reSize() {
        Object[] el = new Object[maxSize << 1];
        for (int i = 0; i < this.size; i++) {
            el[i] = elem[i];
        }
        elem = el;
    }

    public E pop(){
        if(isEmpty()) return null;
        size--;
        return (E) elem[size];
    }

    public E getTop(){
        if(isEmpty()) return null;
        return (E) elem[size-1];
    }
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    private class Itr<E> implements Iterator<E> {
        int nextElem = 0;


        public void remove() {

        }


        public void forEachRemaining(Consumer action) {

        }


        public boolean hasNext() {
            return nextElem < size;
        }


        public E next() {
            return (E) elem[nextElem++];
        }
    }

    public Object[] toArray() {
        if (size == 0) return null;
        Object[] o = new Object[size];
        for (int i = 0; i < size; i++) {
            o[i] = elem[i];
        }
        return o;
    }

    public boolean push(E e) {
        if (this.size == this.maxSize) reSize();
        elem[size++] = e;
        return true;
    }

    public void clear() {
        this.size = 0;
    }


    public E get(int index) {
        if (index < 0 || index >= this.size) return null;
        return (E) elem[index];
    }


    public E set(int index, E element) {
        if (index < 0 || index >= this.size) return null;
        E element1 = (E) elem[index];
        elem[index] = element;
        return element1;
    }


    public void add(int index, E element) {
    }

    /**
     * 先排除两种错误的情况；
     * 移动index之后的元素（包含index）
     * 将element赋值给elem[index]
     * 当前元素大小++
     *
     * @param index   索引值
     * @param element 元素值
     * @return boolean true为成功 false为失败
     */
    public boolean insert(int index, E element) {
        if (index < 0 || index >= this.size) return false;
        if (this.size == this.maxSize) reSize();
        for (int i = this.size - 1; i >= index; i--) {
            elem[i + 1] = elem[i];
        }
        elem[index] = element;
        this.size++;
        return true;
    }


    public E remove(int index) {
        if (index < 0 || index >= this.size) return null;
        E elem1 = (E) elem[index];
        if (index != this.size - 1) {
            for (int i = index + 1; i < this.size; i++) {
                elem[i - 1] = elem[i];
            }
        }
        size--;
        return elem1;
    }


    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (o.equals(elem[i])) return i;
        }
        return -1;
    }
}
