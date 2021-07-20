package datastruct.myutil;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/19 16:44
 */
public class MyLinkedListTest<E> implements List<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> start;

    public MyLinkedListTest() {
        this.start = new Node<>(null);
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
        int i = 0;
        Node<E> newList = start.next;
        while (newList != null) {
            i++;
            newList = newList.next;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return this.start.next == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
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
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public void clear() {
        this.start.next = null;
    }

    @Override
    public E get(int index) {
        Node<E> ptr = start.next;
        int i = 0;
        while (i < index) {
            i++;
            ptr = ptr.next;
        }
        Node<E> newPtr = ptr.next;

        return newPtr.data;
    }

    @Override
    public E set(int index, E element) {
        Node<E> ptr = start;

        return null;
    }

    @Override
    public void add(int index, E element) {
        Node<E> ptr = start;
        int i = 0;
        while (ptr.next != null && i < index) {
            ptr = ptr.next;
            i++;
        }
        if (ptr == null || i > index) return;
        Node<E> newPtr = ptr;
        newPtr.data = element;
        ptr.next = newPtr;
    }

    @Override
    public E remove(int index) {
        //
        Node<E> ptr = this.start;
        int i = 0;
        while (ptr.next != null && i < index) {
            i++;
            ptr = ptr.next;
        }
        if (ptr.next == null || index < i) return null;
        Node<E> newPtr = ptr.next;
        ptr.next = newPtr.next;
        newPtr.next = null;
        return newPtr.data;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> newPtr = this.start.next;
        int i = 0;
        while (!newPtr.data.equals(o) && newPtr != null) {
            i++;
            newPtr = newPtr.next;
        }
        return newPtr != null ? i : -1;
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
