package domain;

import domain.line.RowLine;
import domain.name.Name;
import domain.name.Names;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<Name, Prize> gameResult;

    private LadderResult(Map<Name, Prize> gameResult) {
        this.gameResult = gameResult;
    }

    public static LadderResult of(Ladder ladder, Names names, Prizes prizes) {
        Map<Name, Prize> gameResult = new LinkedHashMap<>();
        List<RowLine> lines = ladder.getLines();

        for (int position = 0; position < names.getNameCount(); position++) {
            int endPosition = moveEachPerson(position, lines);
            gameResult.put(names.getNames().get(position), prizes.getPrizes().get(endPosition));
        }
        return new LadderResult(gameResult);
    }

    private static int moveEachPerson(int position, List<RowLine> lines) {
        for (int height = 0; height < lines.size(); height++) {
            Direction direction = findDirection(lines, height, position);
            position = movePosition(direction, position);
        }
        return position;
    }

    private static Direction findDirection(List<RowLine> lines, int height, int position) {
        List<ConnectionStatus> lineStatus = lines.get(height).getConnections();
        if (position < lineStatus.size() && lineStatus.get(position).isConnect()) {
            return Direction.RIGHT;
        }
        if (position > 0 && lineStatus.get(position - 1).isConnect()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private static int movePosition(Direction direction, int position) {
        if (direction.equals(Direction.RIGHT)) {
            position++;
        }
        if (direction.equals(Direction.LEFT)) {
            position--;
        }
        return position;
    }

    public Map<Name, Prize> getResult() {
        return Collections.unmodifiableMap(gameResult);
    }
}
