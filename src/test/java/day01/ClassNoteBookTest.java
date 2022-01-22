package day01;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    ClassNoteBook classNoteBook;

    @BeforeEach
    void init(){
        classNoteBook = new ClassNoteBook();
        classNoteBook.addStudent(new Student(1,"jhon"));
        classNoteBook.addStudent(new Student(2,"jhony"));
        classNoteBook.addStudent(new Student(3,"jhona"));
        classNoteBook.addMark(1,1);
        classNoteBook.addMark(2,2);
        classNoteBook.addMark(3,3);
        classNoteBook.addMark(1,4);
        classNoteBook.addMark(2,5);
        classNoteBook.addMark(3,6);
    }


    @org.junit.jupiter.api.Test
    void addMarkTest() {
        System.out.println(classNoteBook.getDiary());
    }

    @org.junit.jupiter.api.Test
    void addStudentTest() {
    }
}