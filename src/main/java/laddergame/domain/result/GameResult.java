package laddergame.domain.result;

import laddergame.NameList;
import laddergame.domain.ladder.Ladder;

import java.util.*;

public class GameResult {
    private final Map<String, String> gameResults;

    private GameResult(NameList players, NameList rewards, Ladder ladder) {
        this.gameResults = new HashMap<>();
        init(players, rewards, ladder);
    }

    private void init(NameList players, NameList rewards, Ladder ladder) {
        for (int i = 1; i <= players.getSize(); i++) {
            int destination = ladder.findDestination(i);
            gameResults.put(players.getNameOfIndex(i), rewards.getNameOfIndex(destination));
        }
    }

    public static GameResult of(NameList players, NameList rewards, Ladder ladder) {
        return new GameResult(players, rewards, ladder);
    }

    public List<GameResultFormat> getAllGameResultFormat() {
        List<GameResultFormat> ret = new ArrayList<>();
        for (String people : gameResults.keySet()) {
            ret.add(getGameResultFormat(people));
        }
        return ret;
    }

    public GameResultFormat getGameResultFormat(final String name) {
        Optional<String> optResult = Optional.ofNullable(gameResults.get(name));
        return GameResultFormat.of(name, optResult.orElseThrow(
                () -> new IllegalArgumentException("올바른 이름을 입력하세요")
        ));
    }
}
