package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    public static final String ALL = "all";

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 10;

    private final Players players;
    private final Lines lines;
    private final ResultsEntry resultsEntry;

    public Ladder(Players players, ResultsEntry resultsEntry, List<Line> lines) {
        validateHeight(lines);
        this.players = players;
        this.lines = new Lines(lines);
        validateResultsCount(resultsEntry);
        this.resultsEntry = resultsEntry;
    }

    private void validateHeight(List<Line> lines) {
        if (lines.size() < MIN_RANGE || lines.size() > MAX_RANGE) {
            throw new IllegalArgumentException(
                    String.format("사다리 높이는 %d 이상 %d 이하여야 합니다.", MIN_RANGE, MAX_RANGE));
        }
    }

    private void validateResultsCount(ResultsEntry resultsEntry) {
        if (resultsEntry.getResults().size() != players.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
    }

    public Column calculateResult(Column column) {
        return lines.move(column);
    }

    public CalculatedResults getResults(String input) {
        if (input.equals(ALL)) {
            return getTotalResults();
        }
        return getSingleResult(input);
    }

    public CalculatedResults getTotalResults() {
        Map<Player, Result> resultMap = new LinkedHashMap<>();
        for (Player player : players.getPeople()) { // 이 부분에서 getter를 사용한 것이 아쉽다...
            resultMap.put(player, calculateResult(player));
        }
        return new CalculatedResults(resultMap);
    }

    public CalculatedResults getSingleResult(String name) {
        Map<Player, Result> resultMap = new LinkedHashMap<>();
        Player targetPlayer = new Player(name);
        resultMap.put(targetPlayer, calculateResult(targetPlayer));
        return new CalculatedResults(resultMap);
    }

    public Result calculateResult(Player player) {
        Column startColumn = players.findColumnByPerson(player);
        Column resultColumn = calculateResult(startColumn);
        return resultsEntry.getResultByColumn(resultColumn);
    }

    public int getHeight() {
        return lines.getHeight();
    }

    public int getWidth() {
        return lines.getWidth();
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPeople() {
        return players;
    }

    public ResultsEntry getResults() {
        return resultsEntry;
    }
}
