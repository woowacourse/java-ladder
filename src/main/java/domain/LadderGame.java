package domain;


import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;

    private LadderGame(Ladder ladder, Users users, Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
    }

    public static LadderGame of(Ladder ladder, Users users, Rewards rewards) {
        return new LadderGame(ladder, users, rewards);
    }

    public String findUserReward(int index) {
        return rewards.getReward(index);
    }

    public String findUserReward(String name) {
        int index = users.findUser(name).getPosition();
        return rewards.getReward(index);
    }

    public void moveUsers() {
        users.moveUsers(getConnections());
    }

    private List<List<Integer>> getConnections() {
        List<List<Integer>> allConnections = new ArrayList<>();

        for (Line line : ladder.getLines()) {
            allConnections.add(getConnection(line.getPoints()));
        }

        return allConnections;
    }

    private List<Integer> getConnection(List<Boolean> points) {
        List<Integer> connections = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            addIndex(points.get(i), connections, i);
        }

        return connections;
    }

    private void addIndex(boolean point, List<Integer> connections, int index) {
        if (point) {
            connections.add(index);
        }
    }

}
