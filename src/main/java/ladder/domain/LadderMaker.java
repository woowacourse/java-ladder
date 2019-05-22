package ladder.domain;

import ladder.util.RandomHelper;

import java.util.ArrayList;
import java.util.List;

class LadderMaker {
    static List<Line> generateLadder(LadderGameData ladderGameData) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderGameData.getHeight(); i++) {
            lines.add(new Line(generateOneLine(ladderGameData.getPerson().getCountOfPerson())));
        }
        return lines;
    }

    private static List<Boolean> generateOneLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int j = 0; j < countOfPerson; j++) {
            points.add(RandomHelper.randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }
}
