/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 11:00 2019/11/10
 * @Modificd By;
 */

/*
* 使用Java数组,此数组使用的是java的静态数组，由一定的容量限制，
* */
public class Array01 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 29, 39, 49, 59, 69};
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        for (int ar:arr)
            System.out.println(ar);

        arr[2]=99;
        for (int a:arr)
            System.out.println(a);
    }

    }

