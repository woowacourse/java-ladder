package domain;

import domain.line.RowLine;
import domain.line.RowLinesGenerator;
import domain.name.Names;
import domain.prize.Prizes;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private static final int LAST_POINT = 1;

    private final List<RowLine> lines;
    private Map<Integer, Integer> indexConnections;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLinesGenerator rowLinesGenerator, Names names, Height height, Prizes prizes) {
        validatePersonPrizesCount(names, prizes);
        List<RowLine> lines = rowLinesGenerator.generateLines(names.size(), height.getHeight());
        return new Ladder(lines);
    }

    private static void validatePersonPrizesCount(Names names, Prizes prizes) {
        if (prizes.size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 상품의 수는 참여자 수와 일치해야 합니다.");
        }
    }

    public Map<Integer, Integer> matchLadderPoints() {
        indexConnections = new LinkedHashMap<>();
        for (int position = 0; position < countStartingPoints(); position++) {
            int endPosition = findEndPosition(position);
            indexConnections.put(position, endPosition);
        }
        return Collections.unmodifiableMap(indexConnections);
    }

    private int countStartingPoints() {
        return lines.get(0).size() + LAST_POINT;
    }

    private int findEndPosition(int position) {
        for (int height = 0; height < lines.size(); height++) {
            position = movePosition(height, position);
        }
        return position;
    }

    private int movePosition(int height, int position) {
        RowLine rowLine = lines.get(height);
        return position + rowLine.findConnectedDirection(position);
    }

    public int findPrizeIndex(int nameIndex) {
        return indexConnections.get(nameIndex);
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }
}
