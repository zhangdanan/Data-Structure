/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 15:51 2019/11/10
 * @Modificd By;
 */
public class Student {

    private String name;
    private String score;

    public Student(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Array03<Student> arr=new Array03 <>();
        arr.addlast(new Student("zhang","100"));
        arr.addlast(new Student("wang","80"));
        arr.addlast(new Student("lui","50"));
        System.out.println(arr);
    }
}
