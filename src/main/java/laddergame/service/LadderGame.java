package laddergame.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import laddergame.domain.GameResult;
import laddergame.domain.GameResults;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Point;
import laddergame.domain.User;
import laddergame.domain.Users;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final GameResults gameResults;

    public LadderGame(Ladder ladder, Users users, GameResults gameResults) {
        this.ladder = ladder;
        this.users = users;
        this.gameResults = gameResults;
    }

    public Map<String, String> play() {
        Map<String, String> gameResultByUserName = new LinkedHashMap<>();
        for (User user : users.getUsers()) {
            int userPosition = users.getUsers().indexOf(user);

            userPosition = progressLines(userPosition);

            GameResult gameResult = gameResults.getResults().get(userPosition);
            gameResultByUserName.put(user.getName(), gameResult.getResult());
        }
        return gameResultByUserName;
    }

    private int progressLines(int userPosition) {
        for (Line line : ladder.getLines()) {
            userPosition = moveUserByConnectionStatus(userPosition, line);
        }
        return userPosition;
    }

    private int moveUserByConnectionStatus(int userPosition, Line line) {
        List<Point> points = line.getPoints();
        
        if (isMovableToRight(userPosition, points)) {
            return ++userPosition;
        }
        if (isMovableToLeft(userPosition, points)) {
            return --userPosition;
        }

        return userPosition;
    }

    private boolean isMovableToRight(int userPosition, List<Point> points) {
        return userPosition < points.size() && points.get(userPosition).isConnected();
    }

    private boolean isMovableToLeft(int userPosition, List<Point> points) {
        return userPosition > 0 && points.get(userPosition - 1).isConnected();
    }
}
