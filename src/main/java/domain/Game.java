package domain;

import domain.ladder.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private ArrayList<String> names;
    private List<Line> lines;

    public Game(List<String> names, List<Line> lines) {
        this.names = new ArrayList<>(names);
        this.lines = lines;
    }

    public List<String> executeGame() {
        for (Line line : lines) {
            compareLineAndUsers(names, line.getPoints());
        }
        return names;
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
}
