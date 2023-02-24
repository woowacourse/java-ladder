package ladder.controller;

import java.util.List;
import ladder.domain.Bottoms;
import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameCreateLineBooleanGenerator;
import ladder.domain.Players;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameRunner {

    private static final String ALL_CONDITION = "all";
    private boolean QUIT_CONDITION = true;
    private final LadderGameCreateLineBooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameRunner(
            final LadderGameCreateLineBooleanGenerator booleanGenerator,
            final InputView inputView,
            final OutputView outputView
    ) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readPlayers();
        final Bottoms bottoms = readBottoms(players);
        final Height height = readHeight();

        final LadderGame ladderGame = new LadderGame(booleanGenerator, players, height);
        outputView.printResult(ladderGame, bottoms);

        playLadderGame(ladderGame, bottoms, height);
    }

    private void playLadderGame(final LadderGame ladderGame, final Bottoms bottoms, final Height height) {
        Players earlyPlayers = new Players(ladderGame.getPlayerNames());
        Players playersWhoFinishedGame = ladderGame.makePlayersWhoFinishedGame(height);
        Result result = new Result(playersWhoFinishedGame, bottoms);

        searchLadderGameResultByInput(result, earlyPlayers);
    }

    private void searchLadderGameResultByInput(final Result result, final Players earlyPlayers) {
        while (QUIT_CONDITION) {
            String input = readSearchLadderGameResultInput(result);
            Result searchResult = result.resultByName(input);
            outputView.printSearchResult(searchResult, earlyPlayers);
            isInputAll(input);
        }
    }

    private void isInputAll(final String input) {
        if (input.equals(ALL_CONDITION)) {
            QUIT_CONDITION = false;
        }
    }

    private String readSearchLadderGameResultInput(final Result result) {
        try {
            String input = inputView.readSearchName();
            result.isExistPlayerName(input);
            return input;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readSearchLadderGameResultInput(result);
        }
    }

    private Bottoms readBottoms(final Players players) {
        try {
            final List<String> bottomsInput = inputView.readBottoms();
            return new Bottoms(bottomsInput, players);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readBottoms(players);
        }
    }

    private Players readPlayers() {
        try {
            final List<String> names = inputView.readPlayerNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readPlayers();
        }
    }

    private Height readHeight() {
        try {
            int input = inputView.readLadderHeight();
            return new Height(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readHeight();
        }
    }
}
