import java.util.List;

/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 9:36 2019/11/12
 * @Modificd By;
 */


/*使用数组搭建的栈
* */
class ArrayStack<E> implements Stack<E> {
    Array<E> array;


    public ArrayStack(int capacity) {
        array=new Array <>(capacity);
    }

    public ArrayStack() {
        array=new Array <>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addlast(e);
    }
    @Override
    public E pop() {
        return array.deleteLast();
    }

    @Override
    public E peek() {
        return array.getlast();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Stack:");
        stringBuilder.append("[");
        for (int i=0;i<array.getSize();i++){
            stringBuilder.append(array.get(i));
            if(i!=array.getSize()-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]top");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack=new ArrayStack <>();
        for (int i=0;i<5;i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
    }
}
