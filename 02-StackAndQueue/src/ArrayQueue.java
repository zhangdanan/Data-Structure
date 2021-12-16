/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 7:56 2019/11/16
 * @Modificd By;
 */

/*
* 使用动态数组构建的队列
*
*
* 存在的问题是getFront(),isEmpty(),getSize()这些方法的测试的结果是不正确的
* */
public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity){
        array=new Array <>(capacity);
    }

    public ArrayQueue(){
        array=new Array <>();
    }

    @Override
    public void enqueue(E e) {
        array.addlast(e);
    }

    @Override
    public E dequeue() {
        return array.deleteFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("top:[");
        for (int i=0;i<array.getSize();i++){
             stringBuilder.append(array.get(i));
             if (i!=array.getSize()-1)
                 stringBuilder.append(",");
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue=new ArrayQueue <>();

        for (int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        arrayQueue.dequeue();
        System.out.println(arrayQueue);

        arrayQueue.getFront();
        System.out.println(arrayQueue);

        arrayQueue.getSize();
        System.out.println(arrayQueue);

        arrayQueue.isEmpty();
        System.out.println(arrayQueue);

    }


}
