/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 11:16 2019/11/10
 * @Modificd By;
 */

/*
* 二次封装数组,这个数组是个动态数组，这个是添加元素、查询元素、修改元素、删除元素和判断元素
*
* 这个数组只能放入int类型的数据
* */
public class Array02 {
    private int[] data;
    private int size;

    public Array02(int capacity) {
        data=new int[capacity];
        size=0;
    }

    public Array02(){
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
    public void addlast(int e){
        add(size,e);
//        if (size==data.length)
//            throw new IllegalArgumentException("addlist is failed,Array is full");
//        data[size]=e;
//        size++;
    }

    //向所有元素前添加一个元素
    public void addfirst(int e){
        add(0,e);
    }

    //向index位置添加元素
    public void add(int index,int e){
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
     public int get(int index){
         if(index<0||index>size)
             throw new IllegalArgumentException("add is failed,Array is full");
         return data[index];
     }

     //修改index位置的元素为e
    public void set(int index,int e){
        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");
        data[index]=e;
    }

    //查找数组中是否由e这个元素
    public boolean contain(int e){
        for (int i = 0; i <size ; i++) {
            if (data[i]==e)
                return true;
        }
        return false;
    }
    //查找数组元素e元素的索引
    public int find(int e){
        for (int i = 0; i <size ; i++) {
            if (data[i]==e)
                return i;
        }
        return -1;
    }

    //删除指定位置的元素
    public  void delete(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("add is failed,Array is full");

        int res=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
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
        Array02 arr=new Array02(20);
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
