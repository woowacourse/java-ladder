package domain;

import java.util.List;

public class Game {

    private final Members members;
    private final Ladder ladder;
    private final Rewards rewards;
    private final GameResult gameResult;

    public Game(Members members, Ladder ladder, Rewards rewards) {
        this.members = members;
        this.ladder = ladder;
        this.rewards = rewards;
        this.gameResult = new GameResult();
    }

    public GameResult matchResult() {
        for (Member member : members.getMembers()) {
            int firstPosition = members.findPositionOfMember(member);
            int finalPosition = tryMoveAll(firstPosition);
            Reward reward = rewards.findResultByPosition(finalPosition);
            gameResult.addGameResult(member, reward);
        }
        return gameResult;
    }

    private int tryMoveAll(int index) {
        for (Line line : ladder.getLines()) {
            List<Connection> connections = line.getConnections();
            index = tryMove(connections, index);
        }
        return index;
    }

    private int tryMove(List<Connection> connections, int index) {
        if (canMoveLeft(connections, index)) {
            return index - 1;
        }
        if (canMoveRight(connections, index)) {
            return index + 1;
        }
        return index;
    }

    private boolean canMoveLeft(List<Connection> connections, int index) {
        if (index <= 0) {
            return false;
        }
        Connection left = connections.get(index - 1);
        return left.equals(Connection.CONNECTED);
    }

    private boolean canMoveRight(List<Connection> connections, int index) {
        if (index > connections.size() - 1) {
            return false;
        }
        Connection right = connections.get(index);
        return right.equals(Connection.CONNECTED);
    }

    public Members getMembers() {
        return members;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Rewards getResults() {
        return rewards;
    }
}
