package domain.game;

import domain.ladder.Ladder;
import domain.result.Results;
import domain.user.Users;

import java.util.LinkedHashMap;
import java.util.List;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(final Users users, final Ladder ladder, final Results results) {
        this.users = users;
        this.ladder = ladder;
        this.results = results;
    }

    public GameResult getResult() {
        GameResult gameResult = new GameResult(new LinkedHashMap<>());
        List<String> prizeNames = results.getPrizeNames();
        List<String> userNames = users.getUserNames();

        for (int i = 0; i < userNames.size(); i++) {
            int resultIndex = ladder.climb(i);
            gameResult.save(userNames.get(i), prizeNames.get(resultIndex));
        }
        return gameResult;
    }
}
