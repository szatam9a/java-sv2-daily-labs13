package day01;

import java.util.*;

public class ClassNoteBook {
    private TreeMap<Integer, List<Integer>> diary = new TreeMap<>();

    public void addMark(int id, int mark) {
        List<Integer> result = findStudent(id);
        result.add(mark);
        diary.put(id, result);

    }

    private List<Integer> findStudent(int id) {
        for (Map.Entry entry : diary.entrySet()) {
            if (entry.getKey().equals(id)) return (List<Integer>) entry.getValue();
        }
        throw new IllegalArgumentException("No student by ID");
    }

    public void addStudent(Student student) {
        diary.put(student.getID(), new LinkedList<>());
    }

    public TreeMap<Integer, List<Integer>> getDiary() {
        return diary;
    }
}
