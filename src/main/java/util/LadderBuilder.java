package util;

import domain.Ladder;
import domain.Line;
import domain.Name;
import domain.Players;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Line> iterator = ladder.iterator();
        List<String> ladderString = new ArrayList<>();
        while (iterator.hasNext()) {
            ladderString.add(fromLine(iterator.next()));
        }
        return ladderString;
    }

    private static String fromLine(Line line) {
        Iterator<Connection> iterator = line.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().getBridge());
        }
        return stringBuilder.toString();
    }
}
