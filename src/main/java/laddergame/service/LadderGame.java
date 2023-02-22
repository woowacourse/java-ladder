package laddergame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    public Map<String, String> start() {
        Map<Integer, User> userByPosition = new HashMap<>();

        int initialPosition = 0;
        for (User user : users.getUsers()) {
            userByPosition.put(initialPosition++, user);
        }

        for (Line line : ladder.getLines()) {
            List<Point> points = line.getPoints();
            for (int position = 0; position < users.count() - 1; position++) {
                Point point = points.get(position);
                if (point.isConnected()) {
                    User swapUser = userByPosition.get(position);
                    userByPosition.put(position, userByPosition.get(position + 1));
                    userByPosition.put(position + 1, swapUser);
                }
            }
        }

        Map<User, GameResult> gameResultByUser = new HashMap<>();
        for (Entry<Integer, User> entry : userByPosition.entrySet()) {
            User user = entry.getValue();
            Integer position = entry.getKey();
            List<GameResult> results = gameResults.getResults();

            gameResultByUser.put(user, results.get(position));
        }

        return convertToDataMap(gameResultByUser);
    }

    private Map<String, String> convertToDataMap(Map<User, GameResult> gameResultByUser) {
        Map<String, String> gameResultByUserName = new HashMap<>();
        for (Entry<User, GameResult> entry : gameResultByUser.entrySet()) {
            String userName = entry.getKey().getName();
            String gameResult = entry.getValue().getResult();

            gameResultByUserName.put(userName, gameResult);
        }
        return gameResultByUserName;
    }

}
