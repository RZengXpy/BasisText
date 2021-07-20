package datastruct.myutil;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;


/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/20 15:50
 */

public class MyLinkedStack<E> implements MyStack<E>,Iterable<E> {
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
            this.next = null;
        }
    }

    /**
     * 定义头节点
     */
    private Node<E> linkList;

    /**
     * 头节点的初始化
     */
    public MyLinkedStack() {
        //无头结点
//        this.linkList = null;
        //有头节点
        this.linkList = new Node<E>(null);
    }


    public int size() {
        Node<E> ptr = this.linkList.next;
        int i = 0;
        while (ptr != null) {
            ptr = ptr.next;
            i++;
        }
        return i;
    }


    public boolean isEmpty() {
        return this.linkList.next == null;
    }

    @Override
    public boolean push(E e) {
        Node<E> ptr = new Node<>(e);
        ptr.next=linkList.next;
        linkList.next=ptr;
        return true;
    }
    @Override
    public E pop() {
        if(isEmpty()) return null;
        Node<E> ptr = linkList.next;
        linkList.next=ptr.next;
        ptr.next=null;
        return (E)ptr.data;
    }

    @Override
    public E getTop() {
        return isEmpty() ? null : (E)linkList.next.data;
    }

    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }


    public Iterator<E> iterator() {
        return new Itr<E>();
    }

    private class Itr<E> implements Iterator<E> {
        Node nextElem = linkList.next;


        public void remove() {

        }


        public void forEachRemaining(Consumer action) {

        }


        public boolean hasNext() {
            return nextElem != null;
        }


        public E next() {
            E data = (E) nextElem.data;
            nextElem = nextElem.next;
            return data;
        }
    }


    public Object[] toArray() {
        int size = this.size();
        if (size == 0) return null;
        Object[] o = new Object[size];
        Node<E> ptr = linkList.next;

        for (int i = 0; i < size; i++) {
            o[i] = ptr.data;
            ptr = ptr.next;
        }
        return o;
    }


    public boolean add(E e) {
        Node<E> ptr = this.linkList;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node<>(e);
        return ptr.next != null;
    }


    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1) return false;
        this.remove(index);
        return true;
    }


    public boolean containsAll(@NotNull Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }


    public void clear() {
        linkList.next = null;
    }


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


    public E remove(int index) {
        //确保0号节点的删除
        Node<E> ptr = this.linkList;
        int i = 0;
        while (ptr.next != null && i < index) {
            i++;
            ptr = ptr.next;
        }
        if (ptr.next == null || index < i) return null;
        Node<E> newPtr = ptr.next;
        ptr.next = newPtr.next;
        return newPtr.data;
    }


    public int indexOf(Object o) {
        Node<E> ptr = this.linkList.next;
        int i = 0;
        while (!ptr.data.equals(o) && ptr != null) {
            i++;
            ptr = ptr.next;
        }
        return ptr != null ? i : -1;
    }


}
