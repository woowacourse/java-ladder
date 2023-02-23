package laddergame.domain;

import laddergame.util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        lines.clear();
        for (int count = height.getHeight(); count > 0; count--) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
        }
    }

    //TODO : validate 책임 가질 객체 다시 생각해보기. domain 에서 do while 사용 안하기
    public boolean validate(int height) {
        if (height != 1) {
            HashMap<Integer, Integer> falseIndexCountmap = new HashMap<>();
            for (Line line : lines) {
                falseIndexCountmap = line.checkFalseIndex(falseIndexCountmap);
            }
            if (falseIndexCountmap.containsValue(height)) {
                return false;
            }
        }
        return true;
    }

    public List<Line> getLines() {
        return lines;
    }
}
