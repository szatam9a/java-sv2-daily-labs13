package day02;

import java.util.Set;

public class Answer {
    private String id;
    private Set<String> answer;

    public String getId() {
        return id;
    }


    public Set<String> getAnswer() {
        return answer;
    }

    public Answer(String id, Set<String> answer) {
        this.id = id;
        this.answer = answer;
    }
}
