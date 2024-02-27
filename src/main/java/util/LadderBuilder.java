package util;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Players;
import domain.Winning;
import domain.Winnings;
import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {

    private LadderBuilder() {}

    public static List<String> getLadder(Players players, Ladder ladder, Winnings winnings) {
        List<String> results = new ArrayList<>();
        results.add(nameBuilder(players));
        results.addAll(LadderBuilder.fromLadder(ladder));
        results.add(winningBuilder(winnings));
        return results;
    }

    static String winningBuilder(Winnings winnings) {
        StringBuilder winningResult = new StringBuilder();
        for (Winning winning : winnings.getWinnings()) {
            winningResult.append(String.format("%6s", winning.getWinning()));
        }
        return winningResult.toString();
    }

    static String nameBuilder(Players players) {
        StringBuilder nameResult = new StringBuilder();
        for (Name player : players.getPlayers()) {
            nameResult.append(String.format("%6s", player.getName()));
        }
        return nameResult.toString();
    }

    static List<String> fromLadder(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LadderBuilder::fromLine)
                .toList();
    }

    static String fromLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Connection connection : line.getLine()) {
            stringBuilder.append(connection.getBridge());
        }
        return stringBuilder.toString();
    }
}
