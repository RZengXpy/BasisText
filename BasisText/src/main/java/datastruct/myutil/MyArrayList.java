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

public class MyArrayList<E> implements List<E> {
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
    public MyArrayList() {
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

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    private class Itr<E> implements Iterator<E> {
        int nextElem = 0;

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }

        @Override
        public boolean hasNext() {
            return nextElem < size;
        }

        @Override
        public E next() {
            return (E) elem[nextElem++];
        }
    }

    @NotNull
    @Override
    public Object[] toArray() {
        if (size == 0) return null;
        Object[] o = new Object[size];
        for (int i = 0; i < size; i++) {
            o[i] = elem[i];
        }
        return o;
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (this.size == this.maxSize) reSize();
        elem[size++] = e;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) return null;
        return (E) elem[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= this.size) return null;
        E element1 = (E) elem[index];
        elem[index] = element;
        return element1;
    }

    @Override
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

    @Override
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

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (o.equals(elem[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
