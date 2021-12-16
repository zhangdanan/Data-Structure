import java.util.ArrayList;

/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 16:07 2019/11/10
 * @Modificd By;
 */


/*
 * 比较完善的数组，里面有扩容机制的实现
 *
 * 存在的问题是当测试容量是10以上的时候，会出现空值,出
 * 现这种状况的原因是因为在扩容的时候，for循环语句的判断是当i<size,
 * 这个size的初始值就是10，所以在数组长度在10以下的时候，
 * 能够正常显示每个数组元素的值，但是当长度在10以上的时候就会有很多空值
 * 初步判断是扩容机制还不够完善，可能这个还是最简单的扩容机制，只是为了讲解用的，还是要看源码的解决思想。
 *
 *
 * 解决问题的方案：自己真是不细心啊，在扩容的实现中，对于语句的缩进没有太注意，
 *   for (int i = 0; i < size; i++){
            newData[i] = data[i];
            data = newData;}
     这是错误的，

       for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
     这才是正确的，
 * */
public class Array04<E> {
    private E[] data;
    private int size;

    public Array04(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array04() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后面添加一个元素
    public void addlast(E e) {
        add(size, e);
//        if (size==data.length)
//            throw new IllegalArgumentException("addlist is failed,Array is full");
//        data[size]=e;
//        size++;
    }

    //向所有元素前添加一个元素
    public void addfirst(E e) {
        add(0, e);
    }

    //扩容的逻辑
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    //向index位置添加元素
    public void add(int index, E e) {
        if (size == data.length)
            resize(2 * data.length);

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add is failed,Array is full");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add is failed,Array is full");
        return data[index];
    }

    //修改index位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add is failed,Array is full");
        data[index] = e;
    }

    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组元素e元素的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除指定位置的元素
    public E delete(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add is failed,Array is full");

        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects ！=memory leak
        if (size == data.length / 4 && data.length != 0)
            resize(data.length / 2);
        return res;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E deleteFirst() {
        return delete(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E deleteLast() {
        return delete(size - 1);
    }

    //从数组中删除元素e
    public void deleteElement(E e) {
        int index = find(e);
        if (index != -1)
            delete(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array:size=%d,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Array04 <Integer> arr = new Array04();
        for (int i = 0; i < 10; i++)
            arr.addlast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        /*arr.addfirst(-1);
        System.out.println(arr);

        arr.set(2,99);
        System.out.println(arr);

        arr.get(3);
        System.out.println(arr);

        arr.delete(0);
        System.out.println(arr);*/
    }
}
