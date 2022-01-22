package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TheBigContestTest {
    TheBigContest theBigContest;

    @BeforeEach
    void init() {
        theBigContest = new TheBigContest(Path.of("src/test/resources/answers.txt"));
    }

    @Test
    void bestPlayerTest() {
        System.out.println(theBigContest.bestPlayer());
    }

    @Test
    void findAnswerByIdAndIndexTest() {
        theBigContest.findAnswerByIdAndIndex("GH1234",1);
        theBigContest.findAnswerByIdAndIndex("GH1234",2);
        theBigContest.findAnswerByIdAndIndex("GH1234",3);
        theBigContest.findAnswerByIdAndIndex("GH1234",4);
        theBigContest.findAnswerByIdAndIndex("GH1234",5);
    }

}