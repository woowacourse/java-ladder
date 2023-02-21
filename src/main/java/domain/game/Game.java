package domain.game;

import domain.ladder.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private ArrayList<String> names;
    private List<Line> lines;

    public Game(List<String> names, List<Line> lines) {
        this.names = new ArrayList<>(names);
        this.lines = lines;
    }

    public void executeGame() {
        for (Line line : lines) {
            compareLineAndUsers(names, line.getPoints());
        }
    }

    public static List<String> compareLineAndUsers(ArrayList<String> names, List<Boolean> points) {
        for (int index = 1; index < names.size(); index++) {
            swapUser(index, names, points);
        }
        return names;
    }

    private static void swapUser(int index, ArrayList<String> names, List<Boolean> points) {
        if (points.get(index)) {
            Collections.swap(names, index, index - 1);
        }
    }

    public Map<String, String> getLadderResult(Results results) {
        Map<String, String> resultMap = new HashMap<>();
        for (int index = 0; index < names.size(); index++) {
            resultMap.put(names.get(index), results.getResults().get(index));
        }
        return resultMap;
    }
}
