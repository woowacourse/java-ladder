package domain;

import java.util.List;

public class Game {

    private final Members members;
    private final Lines lines;
    private final Results results;
    private final GameResult gameResult;

    public Game(Members members, Lines lines, Results results) {
        this.members = members;
        this.lines = lines;
        this.results = results;
        this.gameResult = new GameResult();
    }

    public GameResult matchResult() {
        for (Member member : members.getMembers()) {

            int index = members.findIndexOfMember(member);

            for (Line line : lines.getLines()) {
                List<Connection> connections = line.getConnections();
                boolean canMoveLeft = canMoveLeft(connections, index);
                if (canMoveLeft) {
                    index--;
                    continue;
                }
                boolean canMoveRight = canMoveRight(connections, index);
                if (canMoveRight) {
                    index++;
                }
            }
            Result result = results.getResultByIndex(index);
            gameResult.addGameResult(member, result);
        }
        return gameResult;
    }

    private boolean canMoveLeft(List<Connection> connections, int index) {
        if (index <= 0) {
            return false;
        }
        Connection left = connections.get(index - 1);
        if (left.equals(Connection.CONNECTED)) {
            return true;
        }
        return false;
    }

    private boolean canMoveRight(List<Connection> connections, int index) {
        if (index > connections.size() - 1) {
            return false;
        }
        Connection right = connections.get(index);
        if (right.equals(Connection.CONNECTED)) {
            return true;
        }
        return false;
    }

    public Members getMembers() {
        return members;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }
}
