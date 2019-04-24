public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d",name,score);
    }

    public static void main(String[] args) {
        Array2<Student> arr=new Array2<>();
        arr.addLast(new Student("zhangyanna",100));
        arr.addLast(new Student("li",99));
        arr.addLast(new Student("lier",60));
        System.out.println(arr);
    }
}
