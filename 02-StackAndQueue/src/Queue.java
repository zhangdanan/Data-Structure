/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 7:54 2019/11/16
 * @Modificd By;
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
