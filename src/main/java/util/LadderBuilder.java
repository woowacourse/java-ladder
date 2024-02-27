package util;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Players;

import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {

    private LadderBuilder() {}

    public static List<String> getResult(Players players, Ladder ladder) {
        StringBuilder nameResult = new StringBuilder();
        for (Name player : players) {
            nameResult.append(String.format("%6s", player.getName()));
        }
        List<String> results = new ArrayList<>();
        results.add(nameResult.toString());
        results.addAll(LadderBuilder.fromLadder(ladder));
        return results;
    }

    private static List<String> fromLadder(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LadderBuilder::fromLine)
                .toList();
    }

    private static String fromLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Connection connection : line.getLine()) {
            stringBuilder.append(connection.getBridge());
        }
        return stringBuilder.toString();
    }
}
