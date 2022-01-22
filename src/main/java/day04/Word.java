package day04;

import java.util.*;

public class Word {
    private static final List<Character> filter = new LinkedList<>(List.of('a', 'A', 'e', 'E', 'u', 'U', 'i', 'I', 'o', 'O'));
    private Map<Character, Integer> result = new HashMap<>();

    public Map<Character, Integer> countMe(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (inTheFilter(word.charAt(i))) {
                manageAddValue(word.charAt(i));
            }
        }
        return result;
    }

    private boolean inTheFilter(Character c) {
        return (filter.contains(c));
    }

    private void manageAddValue(Character c) {
        if (!result.containsKey(c)) {
            result.put(c, 1);
            return;
        }
        result.put(c, result.get(c) + 1);
    }
}
