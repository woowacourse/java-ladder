package ladderGame.controller;

import ladderGame.model.*;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

import java.util.List;
import java.util.stream.Stream;

public class LadderGameController {
    private final String EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS = "사다리 결과 수가 참여자 수와 동일하지 않습니다.";
    private final String ALL_RESULT_COMMAND = "all";

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        LadderGame ladderGame = makeLadderGame();

        String playerName;
        while (!(playerName = inputView.inputResultWantPlayerName()).equals(ALL_RESULT_COMMAND)) {
            resultView.printLadderResult(ladderGame.findLadderGameResult(playerName));
        }

        resultView.printAllLadderResult(ladderGame.findAllLadderGameResults());
    }

    private LadderGame makeLadderGame() {
        Players players = new Players(inputView.inputPlayerNames());
        LadderResults ladderResults = new LadderResults(inputView.inputLadderResults());

        validatePlayerCountToLadderResultCount(players, ladderResults);

        Ladder ladder = makeLadder(players.getPlayerSize());
        resultView.printLadder(players.getPlayers(), ladder.getLines(), ladderResults.getLadderResults());
        return new LadderGame(players, ladderResults, ladder);
    }

    private void validatePlayerCountToLadderResultCount(Players players, LadderResults ladderResults) {
        if (players.getPlayerSize() != ladderResults.getLadderResultsSize()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_EQUALS_PLAYERS_LADDER_RESULTS);
        }
    }

    private Ladder makeLadder(int playerCount) {
        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makePlayerConnections(playerCount)))
                .limit(inputView.inputMaxLadderHeight())
                .toList();

        return new Ladder(lines);
    }
}
