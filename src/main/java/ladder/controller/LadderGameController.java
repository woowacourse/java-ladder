package ladder.controller;

import ladder.domain.game.LadderGame;
import ladder.domain.rule.RandomStoolGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.exception.CustomException;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    public void run() {
        Players players = initPlayers();
        Ladder ladder = initLadder(players.size());
        LadderGame ladderGame = initLadderGame(players, ladder);

        ladderGame.letPlayersToGoDown();
        showResult(ladderGame);
        startCheckingGameResultLoop(ladderGame);
    }

    private Players initPlayers() {
        try {
            List<String> playerNames = InputView.inputPlayer();
            return new Players(playerNames);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initPlayers();
        }
    }

    private Ladder initLadder(int playerNumber) {
        try {
            final int height = InputView.inputLadderHeight();
            return new Ladder(playerNumber, height, new RandomStoolGenerator());
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initLadder(playerNumber);
        }
    }

    private LadderGame initLadderGame(Players players, Ladder ladder) {
        try {
            List<String> gameResult = InputView.inputLadderGameResult();
            return new LadderGame(players, ladder, gameResult);
        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            return initLadderGame(players, ladder);
        }
    }

    private void showResult(LadderGame ladderGame) {
        OutputView.printGameResultHeader();
        OutputView.printWithFormat(mapPlayersToPlayersName(ladderGame.getPlayers()));
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printWithFormat(ladderGame.getLadderGameResult());
    }

    private List<String> mapPlayersToPlayersName(Players players) {
        return players.getPlayers().stream()
                .map(player -> player.getPlayerName().getName())
                .collect(Collectors.toUnmodifiableList());
    }

    private void startCheckingGameResultLoop(LadderGame ladderGame) {
        try {
            final String playerName = InputView.inputPlayerWhoNeedsGameResult();

            if (playerName.equals("all")) {
                OutputView.printAllGameResult(ladderGame.getAllLadderGameResult());
                startCheckingGameResultLoop(ladderGame);
            }
            OutputView.printOneGameResult(ladderGame.getOneLadderGameResult(playerName));
            startCheckingGameResultLoop(ladderGame);

        } catch (CustomException e) {
            OutputView.printErrorMessage(e);
            startCheckingGameResultLoop(ladderGame);
        }
    }
}
