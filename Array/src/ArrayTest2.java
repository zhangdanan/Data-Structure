
//Array2的测试类
public class ArrayTest2 {
    public static void main(String[] args) {
        Array2<Integer> arr=new Array2<>(20);
        for (int i = 0; i <10 ; i++)
            arr.addLast(i);
        System.out.println(arr);


        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.addLast(3);
        System.out.println(arr);

        arr.delete(2);
        System.out.println(arr);

        arr.deleteElement(5);
        System.out.println(arr);

        arr.deleteFirst();
        System.out.println(arr);

        arr.deleteLast();
        System.out.println(arr);
    }
}
