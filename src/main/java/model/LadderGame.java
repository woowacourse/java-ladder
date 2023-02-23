package model;

import java.util.List;

public class LadderGame {

    private final Names names;
    private final GameResults gameResults;

    private LadderGame(Names names, GameResults gameResults) {
        this.names = names;
        this.gameResults = gameResults;
    }

    public static LadderGame of(Names names, Ladder ladder, LadderResults ladderResults) {
        GameResults gameResults = GameResults.of(names, ladder, ladderResults);

        return new LadderGame(names, gameResults);
    }

    public List<GameResult> findGameResult(String name) {
        if (LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(name)) {
            return findGameResultByName(name);
        }
        return findGameResultAll();
    }

    private List<GameResult> findGameResultByName(String name) {
        GameResult gameResult = gameResults.findGameResultByName(name);

        return List.of(gameResult);
    }

    private List<GameResult> findGameResultAll() {
        return gameResults.getGameResults();
    }
}
