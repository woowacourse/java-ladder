package util;

import domain.Ladder;
import domain.Line;

import domain.Name;
import domain.Players;
import domain.Winnings;
import java.util.ArrayList;
import java.util.List;

public class LadderSequence {

    private LadderSequence() {}

    public static List<String> of(Players players, Ladder ladder, Winnings winnings) {
        List<String> results = new ArrayList<>();
        results.add(getNamesWithFormat(players.getNames()));
        results.addAll(LadderSequence.getLadderSequence(ladder));
        results.add(getNamesWithFormat(winnings.getNames()));
        return results;
    }

    private static String getNamesWithFormat(List<Name> names) {
        StringBuilder nameResult = new StringBuilder();
        for (Name name : names) {
            nameResult.append(String.format("%6s", name.getName()));
        }
        return nameResult.toString();
    }

    private static List<String> getLadderSequence(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return lines.stream()
                .map(LadderSequence::getLineSequence)
                .toList();
    }

    private static String getLineSequence(Line line) {
        List<Connection> connections = line.getConnections();
        StringBuilder stringBuilder = new StringBuilder();
        connections.stream()
                .map(Connection::getBridge)
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
