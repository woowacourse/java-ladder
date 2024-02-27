package domain;

import java.util.*;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;
    private final Results results;
    private final GameResult gameResult;

    public LadderGame(Users users, Ladder ladder, Results results) {
        this.users = users;
        this.ladder = ladder;
        this.results = results;
        this.gameResult = new GameResult(new LinkedHashMap<>());
    }

    public GameResult getResult() {
        List<String> prizeNames = results.getPrizeNames();
        List<String> userNames = users.getUserNames();

        for (int i = 0; i < userNames.size(); i++) {
            int resultIndex = ladder.climb(i);
            gameResult.save(userNames.get(i), prizeNames.get(resultIndex));
        }
        return gameResult;
    }
}
