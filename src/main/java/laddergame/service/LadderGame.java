package laddergame.service;

import java.util.LinkedHashMap;
import java.util.Map;
import laddergame.domain.GameResult;
import laddergame.domain.Position;
import laddergame.domain.Results;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.User;
import laddergame.domain.Users;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;
    private final Results results;

    public LadderGame(Ladder ladder, Users users, Results results) {
        this.ladder = ladder;
        this.users = users;
        this.results = results;
    }

    public Map<String, String> play() {
        Map<String, String> gameResultByUserName = new LinkedHashMap<>();
        for (User user : users.getUsers()) {
            Position userPosition = new Position(users.getUsers().indexOf(user), users.count());

            progressLines(userPosition);

            GameResult gameResult = results.getResultByPosition(userPosition);
            gameResultByUserName.put(user.getName(), gameResult.getResult());
        }
        return gameResultByUserName;
    }

    private void progressLines(Position userPosition) {
        for (Line line : ladder.getLines()) {
            userPosition.moveByConnectionStatus(line);
        }
    }
}
