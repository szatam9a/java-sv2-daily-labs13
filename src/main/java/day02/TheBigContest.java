package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TheBigContest {
    private String goodAnswers;
    private Map<String, String> idAndAnswers = new HashMap<>();

    public TheBigContest(Path path) {
        readInAndProcess(path);
    }

    private void readInAndProcess(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            goodAnswers = br.readLine();
            String next;
            String[] tmp;
            while ((next = br.readLine()) != null) {
                tmp = next.split(" ");
                addAnswer(tmp[0], tmp[1]);
            }
        } catch (IOException ioException) {
            throw new IllegalArgumentException("no file");
        }
    }

    private void addAnswer(String id, String answer) {
        if (idAndAnswers.containsKey(id)) {
            idAndAnswers.put(id, idAndAnswers.get(id).concat(answer));
            return;
        }
        idAndAnswers.put(id, answer);
    }

    public String bestPlayer() {
        int points = 0;
        String player = "nobody";
        for (Map.Entry<String, String> p : idAndAnswers.entrySet()) {
            int point = pointCalculator(p.getValue());
            if (point > points) {
                player = p.getKey();
                points = point;
            }
        }
        return player;
    }

    private int pointCalculator(String answer) {
        int points = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == goodAnswers.charAt(i)) {
                points += i + 1;
            } else {
                if ('X' != answer.charAt(i)) {
                    points -= 2;
                }
            }
        }
        return points;
    }

    public void findAnswerByIdAndIndex(String id, int index) {
        index--;
        if (!idAndAnswers.containsKey(id)) {
            throw new IllegalArgumentException("no id");
        }
        compareToGoodAnswerAtIndex((findEntryByID(id)), index);

    }

    private boolean compareToGoodAnswerAtIndex(String entryByID, int index) {
        if (entryByID.length() > index || goodAnswers.length() > index) {
            if (entryByID.charAt(index) == goodAnswers.charAt(index)) {
                System.out.println("good answer");
                return true;
            } else {
                System.out.println("false answer");
                return false;
            }
        }
        throw new IllegalArgumentException("no answer was given at this index");
    }

    private String findEntryByID(String id) {
        for (Map.Entry<String, String> map : idAndAnswers.entrySet()) {
            if (map.getKey().equals(id)) {
                return map.getValue();
            }
        }
        throw new IllegalArgumentException("Error in the map");
    }

    public String getGoodAnswers() {
        return goodAnswers;
    }

    public Map<String, String> getIdAndAnswers() {
        return idAndAnswers;
    }
}
