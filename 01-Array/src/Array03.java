/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 15:27 2019/11/10
 * @Modificd By;
 */

/*
* 使用泛型来让我们的数组能够放置多的类对象
*
* 基础类型不行，因为每个基本数据类型都有包装类
*
* */
public class Array03<E> {
    private E[] data;
    private int size;

    public Array03(int capacity) {
        data=(E[]) new Object[capacity];
        size=0;
    }

    public Array03(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后面添加一个元素
    public void addlast(E e){
        add(size,e);
//        if (size==data.length)
//            throw new IllegalArgumentException("addlist is failed,Array is full");
//        data[size]=e;
//        size++;
    }

    //向所有元素前添加一个元素
    public void addfirst(E e){
        add(0,e);
    }

    //向index位置添加元素
    public void add(int index,E e){
        if (size==data.length)
            throw new IllegalArgumentException("add is failed,Array is full");

        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");

        for (int i=size-1;i>=index;i--)
            data[i+1]=data[i];

        data[index]=e;
        size++;
    }
    //获取index索引位置的元素
    public E get(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");
        return data[index];
    }

    //修改index位置的元素为e
    public void set(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");
        data[index]=e;
    }
  public boolean contain(E e){
        for (int i = 0; i <size ; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }
    //查找数组元素e元素的索引
    public int find(E e){
        for (int i = 0; i <size ; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除指定位置的元素
    public  E delete(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");

        E res=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;//loitering objects ！=memory leak
        return res;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E deleteFirst(){
        return delete(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E deleteLast(){
        return delete(size-1);
    }

    //从数组中删除元素e
    public  void deleteElement(E e){
        int index=find(e);
        if (index!=-1)
            delete(index);
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if (i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
    public static void main(String[] args) {
        Array03<Integer> arr=new Array03(20);
        for (int i=0;i<10;i++)
            arr.addlast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addfirst(100);
        System.out.println(arr);

        arr.set(2,99);
        System.out.println(arr);

        arr.get(3);
        System.out.println(arr);

        arr.delete(0);
        System.out.println(arr);
    }
}
