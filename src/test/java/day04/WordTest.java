package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void countMeTest() {
        Word word = new Word();
        System.out.println(word.countMe("Neveraio"));
    }
}