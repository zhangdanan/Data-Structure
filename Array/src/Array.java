
//二次封装自己的数组
public class Array<S> {
    private int[] data;
    private int size;


    //有参数的构造函数，传入数组的容量capacity构造ArrayTest
    public Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;

    }
    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后添加一个元素e
    public void addLast(int e){
        add(size,e);
    }

    //向所有元素前添加一个元素e
    public void addFirst(int e){
        add(0,e);
    }
//    public void addLast(int e){
//        if (size==data.length)
//            throw new IllegalArgumentException("Add failed,Array is full");
//        data[size]=e;
//        size++;
//    }

    //在第Index个位置插入一个新元素e
    public void add(int index,int e){
        if (size==data.length)
            throw new IllegalArgumentException("Add failed,Array is full");
        if (index<0||index>size)
            throw new IllegalArgumentException("Add failed，Require index>=0");
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    //从数组中删除一个元素，返回被删除的值
    public int delete(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("delete failed,Require index>=0");
        int ret=data[index];
        for (int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        return ret;
    }
    //删除数组最后一个元素，并返回被删除的值
    public int deleteLast(){
        return delete(size-1);
    }
    //删除数组第一个元素，并返回被删除的值
    public int deleteFirst(){
        return delete(0);
    }
    //如果数组存在元素e，就从数组中删除元素e，
    public void deleteElement(int e){
        int index=find(e);
        if (index!=-1)
            delete(index);
    }

    //获取index索引位置的元素
    int get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed,index is illega");
        return data[index];
    }
    //修改index索引位置的元素为e
    void set(int index,int e){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Set failed,index is illega");
        data[index]=e;
    }

    //查找数组中是否有元素e
    public boolean contains(int e){
        for (int i=0;i<size;i++){
            if(data[i]==e)
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，返回-1
    public int find(int e){
        for (int i=0;i<size;i++){
            if(data[i]==e)
                return i;
        }
        return -1;
    }



    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for (int i = 0; i <size ; i++) {
            res.append(data[i]);
            if (i!=size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

}
