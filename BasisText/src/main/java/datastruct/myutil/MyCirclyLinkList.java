package datastruct.myutil;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/20 8:25
 */
public class MyCirclyLinkList<E> implements List<E> {

    /**
     * 构造内部类
     *
     * @param <E>
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        //        Node<E> prev;
        Node(E data) {
            this.data = data;
            this.next = this;
        }
    }

    /**
     * 定义头节点
     */
    private Node<E> linkList;

    /**
     * 头节点的初始化
     */
    public MyCirclyLinkList() {
        //无头结点
//        this.linkList = null;
        //有头节点
        this.linkList = new Node<E>(null);
    }

    @Override
    public int size() {
        Node<E> ptr = this.linkList.next;
        int i = 0;
        while (ptr != this.linkList) {
            ptr = ptr.next;
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return this.linkList.next == null;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> ptr = this.linkList;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node<>(e);
        return ptr.next != null;
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1) return false;
        this.remove(index);
        return true;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
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
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public void clear() {
        linkList.next = null;
    }

    @Override
    public E get(int index) {
        int i = 0;
        Node<E> ptr = this.linkList.next;
        while (i < index && ptr != null) {
            i++;
            ptr = ptr.next;
        }
        if (index < i) return null;
        return ptr != null ? ptr.data : null;
    }

    @Override
    public E set(int index, E element) {
        Node<E> ptr = this.linkList.next;
        int i = 0;
        while (ptr != null && i < index) {
            i++;
            ptr = ptr.next;
        }
        if (ptr == null || index < i) return null;
        Node<E> newPte = new Node<E>(ptr.next.data);
        ptr.next.data = element;
        return newPte.data;
    }

    @Override
    public void add(int index, E element) {

    }

    public boolean insert(int index, E element) {
        Node<E> ptr = this.linkList;
        int i = 0;
        for (; i < index && ptr != null; i++) {
            ptr = ptr.next;
        }
        if (ptr == null || index < i) return false;
        Node<E> newPtr = new Node<>(element);
        newPtr.next = ptr.next;
        ptr.next = newPtr;
        return true;

    }

    @Override
    public E remove(int index) {
        //确保0号节点的删除
        Node<E> ptr = this.linkList;
        int i = 0;
        while (ptr != null && i < index) {
            i++;
            ptr = ptr.next;
        }
        if (ptr == null || index < i) return null;
        Node<E> newPtr = ptr.next;
        ptr.next = newPtr.next;
        return newPtr.data;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> ptr = this.linkList.next;
        int i = 0;
        while (!ptr.data.equals(o) && ptr != null) {
            i++;
            ptr = ptr.next;
        }
        return ptr != null ? i : -1;
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

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

}
