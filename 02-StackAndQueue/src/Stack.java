/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 9:34 2019/11/12
 * @Modificd By;
 */
public interface Stack<E> {
    public int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
