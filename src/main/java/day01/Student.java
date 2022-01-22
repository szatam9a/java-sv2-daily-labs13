package day01;

public class Student implements Comparable<Student> {
    private int ID;
    private String name;

    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.ID - o.ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }
}
