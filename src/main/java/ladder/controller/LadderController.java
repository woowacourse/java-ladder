package ladder.controller;

import java.util.List;
import java.util.Map;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.ResultItems;
import ladder.domain.ResultItem;
import ladder.util.RandomLadderGenerator;
import ladder.util.RetryHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = createPlayersWithRetry();
        ResultItems resultItems = createResultWithRetry(players.getSize());
        Height height = createHeightWithRetry();
        Ladder ladder = createLadder(players.getSize(), height.getValue());

        LadderGame ladderGame = new LadderGame(players, resultItems, ladder);
        outputView.printLadderResult(players.getRawPlayers(), ladder.getRawLadder(), resultItems.getRawResultItems());

        playLadderGame(ladderGame);
    }

    private Players createPlayersWithRetry() {
        return RetryHandler.run(this::createPlayersFromInput);
    }

    private Players createPlayersFromInput() {
        List<String> players = inputView.readPlayers();
        return new Players(players);
    }

    private ResultItems createResultWithRetry(int personCount) {
        return RetryHandler.run(() -> createResultFromInput(personCount));
    }

    private ResultItems createResultFromInput(int personCount) {
        List<String> resultItems = inputView.readResultItems();
        return new ResultItems(personCount, resultItems);
    }

    private Height createHeightWithRetry() {
        return RetryHandler.run(this::createHeightFromInput);
    }

    private Height createHeightFromInput() {
        int value = inputView.readHeight();
        return new Height(value);
    }

    private Ladder createLadder(int personCount, int heightValue) {
        RandomLadderGenerator randomLadderGenerator = new RandomLadderGenerator();
        return new Ladder(heightValue, randomLadderGenerator.generate(personCount, heightValue));
    }

    private void playLadderGame(LadderGame ladderGame) {
        while (ladderGame.isInProgress()) {
            Map<Player, ResultItem> result = executeLadderGameWithRetry(ladderGame);
            outputView.printExecutionResult(result);
        }
    }

    private Map<Player, ResultItem> executeLadderGameWithRetry(LadderGame ladderGame) {
        return RetryHandler.run(() -> executeLadderGameFromInput(ladderGame));
    }

    private Map<Player, ResultItem> executeLadderGameFromInput(LadderGame ladderGame) {
        String target = inputView.readTarget();
        return ladderGame.execute(target);
    }
}
