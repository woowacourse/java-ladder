package util;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderSequence {

    private LadderSequence() {}

    public static List<String> from(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        List<String> ladderSequence = new ArrayList<>();
        lines.stream()
                .map(LadderSequence::getLineSequence)
                .forEach(ladderSequence::add);
        return ladderSequence;
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
