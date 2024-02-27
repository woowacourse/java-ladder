package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;


    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public int playLine(int currentColumn, Line line) {
        List<Step> steps = line.getSteps();
        if (steps.get(currentColumn).isExist()) {
            return currentColumn + 1;
        }
        if (currentColumn > 0 && steps.get(currentColumn - 1).isExist()) {
            return currentColumn - 1;
        }
        return currentColumn;
    }

    public int playLines(int currentColumn, List<Line> lines) {
        for (Line line : lines) {
            currentColumn = playLine(currentColumn, line);
        }
        return currentColumn;
    }

    public Map<String, Integer> playPlayers(List<Line> lines, List<String> players) {
        Map<String, Integer> playerWithResultIndex = new LinkedHashMap<>();

        for (int columnIndex = 0; columnIndex < players.size(); columnIndex++) {
            String player = players.get(columnIndex);
            int resultColumnIndex = playLines(columnIndex, lines);
            playerWithResultIndex.put(player, resultColumnIndex);
        }

        return playerWithResultIndex;
    }

    public Map<Player, Integer> playPlayers2() {
        Map<Player, Integer> playerWithResultIndex = new LinkedHashMap<>();

        for (int columnIndex = 0; columnIndex < players.getPlayers().size(); columnIndex++) {
            Player player = players.getPlayers().get(columnIndex);
            int resultColumnIndex = playLines(columnIndex, ladder.getLines());
            playerWithResultIndex.put(player, resultColumnIndex);
        }

        return playerWithResultIndex;    }

    public Map<String, String> getPlayersWithPrize(Map<String, Integer> playersWithResultIndex, List<String> prizes) {
        Map<String, String> playersWithPrize = new LinkedHashMap<>();
        playersWithResultIndex.forEach((player, index) -> {
            playersWithPrize.put(player, prizes.get(index));
        });
        return playersWithPrize;
    }
}
