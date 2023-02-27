package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ladder {

    public static final String ALL = "all";

    private final Players players;
    private final Lines lines;
    private final Results results;

    public Ladder(Players players, Results results, Lines lines) {
        this.players = players;
        this.lines = lines;
        validateResultsCount(results);
        this.results = results;
    }

    private void validateResultsCount(Results results) {
        if (results.getResults().size() != players.getCount()) {
            throw new IllegalArgumentException("실행 결과의 수는 사람 수와 같아야 합니다.");
        }
    }

    public CalculatedResults calculateResults(String input) {
        if (input.equals(ALL)) {
            return getTotalResults();
        }
        return getSingleResult(input);
    }

    public CalculatedResults getTotalResults() {
        Map<Player, Result> resultMap = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) { // 이 부분에서 getter를 사용한 것이 아쉽다...
            resultMap.put(player, calculateResult(player));
        }
        return new CalculatedResults(resultMap);
    }

    public CalculatedResults getSingleResult(String name) {
        Map<Player, Result> resultMap = new LinkedHashMap<>();
        Player player = new Player(name);
        resultMap.put(player, calculateResult(player));
        return new CalculatedResults(resultMap);
    }

    public Result calculateResult(Player player) {
        Column startColumn = players.findColumn(player);
        Column resultColumn = lines.move(startColumn);
        return results.getFinalResult(resultColumn);
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

    public Results calculateResults() {
        return results;
    }
}
