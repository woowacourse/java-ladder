package domain;

import domain.line.RowLine;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderIndexConnection {

    public static final int MOVE = 1;

    private final Map<Integer, Integer> indexConnections;

    private LadderIndexConnection(Map<Integer, Integer> indexConnections) {
        this.indexConnections = indexConnections;
    }

    public static LadderIndexConnection of(Ladder ladder) {
        Map<Integer, Integer> indexConnections = new LinkedHashMap<>();
        List<RowLine> lines = ladder.getLines();

        for (int position = 0; position < ladder.getWidthSize(); position++) {
            int endPosition = movePosition(position, lines);
            indexConnections.put(position, endPosition);
        }
        return new LadderIndexConnection(indexConnections);
    }

    private static int movePosition(int position, List<RowLine> lines) {
        for (int height = 0; height < lines.size(); height++) {
            position = findDirection(lines, height, position);
        }
        return position;
    }

    private static int findDirection(List<RowLine> lines, int height, int position) {
        List<ConnectionStatus> lineStatus = lines.get(height).getConnections();
        if (position < lineStatus.size() && lineStatus.get(position).isConnect()) {
            return position + MOVE;
        }
        if (position > 0 && lineStatus.get(position - 1).isConnect()) {
            return position - MOVE;
        }
        return position;
    }

    public Map<Integer, Integer> getResult() {
        return Collections.unmodifiableMap(indexConnections);
    }

    public int getPrizeIndex(int nameIndex) {
        return indexConnections.get(nameIndex);
    }
}
