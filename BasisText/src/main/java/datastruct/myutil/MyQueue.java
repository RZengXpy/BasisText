package datastruct.myutil;

/**
 * @version 1.0
 * @Description: TODO
 * @Author RZeng
 * @date 2021/7/20 16:59
 */
public interface MyQueue<E> extends Iterable<E>{
    public E deQueue();

    public E peek();

    public int size() ;

    public boolean isEmpty() ;

    public boolean enQueue(E e) ;

    public void clear() ;
}
