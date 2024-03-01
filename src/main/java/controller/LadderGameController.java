package controller;

import java.util.List;
import java.util.function.Supplier;
import model.bridge.RandomBridgesGenerator;
import model.game.Game;
import model.game.GameResult;
import model.game.GameResultState;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.line.LineState;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private static final String END_CONDITION = "all";

    public void run() {
        Game game = prepare();
        play(game);
    }

    private Game prepare() {
        Players players = retryWithReturnOnException(this::preparePlayers);
        Prizes prizes = retryWithReturnOnException(() -> preparePrizes(players));
        LadderHeight ladderHeight = retryWithReturnOnException(this::prepareLadderHeight);
        Ladder ladder = makeLadder(ladderHeight, players, prizes);
        return new Game(players, ladder, prizes);
    }

    private Players preparePlayers() {
        List<String> playerNames = InputView.askPlayerNames();
        return Players.from(playerNames);
    }

    private Prizes preparePrizes(Players players) {
        List<String> prizeNames = InputView.askPrizeNames();
        return Prizes.of(players, prizeNames);
    }

    private LadderHeight prepareLadderHeight() {
        int ladderHeight = InputView.askLadderHeight();
        return new LadderHeight(ladderHeight);
    }

    private Ladder makeLadder(LadderHeight ladderHeight, Players players, Prizes prizes) {
        Ladder ladder = Ladder.of(ladderHeight, players, new RandomBridgesGenerator());
        showLadder(ladder, players, prizes);
        return ladder;
    }

    private void showLadder(Ladder ladder, Players players, Prizes prizes) {
        OutputView.printLadderIntro();
        showPlayerNames(players);
        showLadderLines(ladder);
        showPrizeNames(prizes);
    }

    private void showPlayerNames(Players players) {
        List<String> playerNames = players.getPlayerNames();
        OutputView.printPlayerNames(playerNames);
    }

    private void showLadderLines(Ladder ladder) {
        List<LineState> lines = ladder.captureLadderLines();
        OutputView.printLadderLines(lines);
    }

    private void showPrizeNames(Prizes prizes) {
        List<String> prizeNames = prizes.getPrizeNames();
        OutputView.printPrizeNames(prizeNames);
    }

    private void play(Game game) {
        GameResult gameResult = game.play();
        retryOnException(() -> provideGameResultUntilEnd(gameResult));
    }

    private void provideGameResultUntilEnd(GameResult gameResult) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = provideGameResult(gameResult);
        }
    }

    private boolean provideGameResult(GameResult gameResult) {
        String targetName = InputView.askTargetName();
        OutputView.printGameResultIntro();
        if (targetName.equals(END_CONDITION)) {
            showGameResultForAllPlayers(gameResult);
            return false;
        }
        Player player = new Player(targetName);
        showGameResultForOnePlayer(gameResult, player);
        return true;
    }

    private void showGameResultForAllPlayers(GameResult gameResult) {
        List<GameResultState> result = gameResult.captureResultStates();
        OutputView.printGameResultForAllPlayers(result);
    }

    private void showGameResultForOnePlayer(GameResult gameResult, Player player) {
        Prize prize = gameResult.get(player);
        String prizeName = prize.getName();
        OutputView.printGameResultForOnePlayer(prizeName);
    }

    private <T> T retryWithReturnOnException(Supplier<T> retryOperation) {
        try {
            return retryOperation.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryWithReturnOnException(retryOperation);
        }
    }

    private void retryOnException(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            retryOnException(action);
        }
    }
}
