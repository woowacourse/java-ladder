package view;

import domain.Connection;
import domain.Game;
import domain.Line;
import domain.Ladder;
import domain.Members;
import domain.Result;
import domain.Results;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String CONNECTED_CHARACTER = "-";
    private static final String DISCONNECTED_CHARACTER = " ";
    private static final String FRAME_OF_LADDER = "|";

    public void printLadder(Game game) {
        System.out.println("사다리 결과");
        System.out.println(resolveMembers(game.getMembers()));
        System.out.println(resolveLines(game.getLines()));
        System.out.println(resolveResults(game.getResults()));
    }

    private String resolveMembers(Members members) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : members.getNames()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    private String resolveResults(Results results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : results.getValues()) {
            stringBuilder.append(String.format("%" + MAX_NAME_LENGTH + "s ", name));
        }
        return stringBuilder.toString();
    }

    private String resolveLines(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            stringBuilder.append(resolveLine(line));
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));
        return stringBuilder.toString();
    }

    private String resolveLine(Line line) {
        List<Connection> connections = line.getConnections();
        StringBuilder stringBuilder = new StringBuilder(repeatCharacter(DISCONNECTED_CHARACTER, MAX_NAME_LENGTH - 1));
        for (Connection connection : connections) {
            stringBuilder.append(FRAME_OF_LADDER);
            stringBuilder.append(resolveConnection(connection));
        }
        stringBuilder.append(FRAME_OF_LADDER);
        return stringBuilder.toString();
    }

    private String resolveConnection(Connection connection) {
        if (connection.equals(Connection.CONNECTED)) {
            return repeatCharacter(CONNECTED_CHARACTER, MAX_NAME_LENGTH);
        }
        return repeatCharacter(DISCONNECTED_CHARACTER, MAX_NAME_LENGTH);
    }

    private String repeatCharacter(String character, int times) {
        return character.repeat(times);
    }

    public void printResult(Map<String, Result> results) {
        if (results.size() == 1) {
            System.out.println(results.values().stream().map(Result::getValue).toList().get(0));
            return;
        }
        for (Entry<String, Result> memberResult : results.entrySet()) {
            String memberName = memberResult.getKey();
            String result = memberResult.getValue().getValue();
            System.out.println(memberName + " : " + result);
        }
    }
}
