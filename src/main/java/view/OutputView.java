package view;

import domain.Connection;
import domain.Game;
import domain.Line;
import domain.Lines;
import domain.Members;
import java.util.List;

public class OutputView {

    public static final int MAX_NAME_LENGTH = 5;

    public void printResult(Game game) {
        System.out.println("실행결과");
        System.out.println(resolveMembers(game.getMembers()));
        System.out.println(resolveLines(game.getLines()));
    }

    private String resolveMembers(Members members) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : members.getNames()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    private String resolveLines(Lines ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            stringBuilder.append(resolveLine(line));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String resolveLine(Line line) {
        List<Connection> connections = line.getPoints();
        StringBuilder stringBuilder = new StringBuilder(repeatCharacter(" ", MAX_NAME_LENGTH - 1));
        for (Connection connection : connections) {
            stringBuilder.append("|");
            stringBuilder.append(resolveConnection(connection));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private String resolveConnection(Connection connection) {
        if (connection.equals(Connection.CONNECTED)) {
            return repeatCharacter("-", MAX_NAME_LENGTH);
        }
        return repeatCharacter(" ", MAX_NAME_LENGTH);
    }

    private String repeatCharacter(String character, int times) {
        return character.repeat(times);
    }
}
