package day02;

import java.nio.file.Path;

public class userInterface {
    public static void main(String[] args) {
        TheBigContest game = new TheBigContest(Path.of("src/test/resources/answers.txt"));
    }
}
