package domain;

import java.util.HashMap;
import java.util.List;

public class Game {

    private final Members members;
    private final Lines lines;

    public Game(Members members, Lines lines) {
        this.members = members;
        this.lines = lines;
    }

    public HashMap<String, Result> matchResult(Results results) {
        HashMap<String, Result> gameResult = new HashMap<>();

        for (Member member : members.getMembers()) {

            int index = members.findIndexOfMember(member);

            for (Line line : lines.getLines()) {
                List<Connection> connections = line.getConnections();
                index = tryMoveLeft(connections, index);
                index = tryMoveRight(connections, index);
            }
            Result result = results.getResultByIndex(index);
            gameResult.put(member.getName(), result);
        }

        return gameResult;
    }

    private int tryMoveLeft(List<Connection> connections, int index) {
        if (index <= 0) {
            return index;
        }
        Connection left = connections.get(index - 1);
        if (left.equals(Connection.CONNECTED)) {
            index--;
        }
        return index;
    }

    private int tryMoveRight(List<Connection> connections, int index) {
        if (index >= connections.size() - 1) {
            return index;
        }
        Connection right = connections.get(index);
        if (right.equals(Connection.CONNECTED)) {
            index++;
        }
        return index;
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }
}
