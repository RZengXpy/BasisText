package datastruct.myutil;

import java.util.*;


/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/20 14:43
 */
public interface MyStack<E> extends Iterable<E>{

    public Object[] toArray();

    public Iterator<E>  iterator();

    public E pop();

    public E getTop();

    public int size() ;

    public boolean isEmpty() ;

    public boolean push(E e) ;

    public void clear() ;

}
