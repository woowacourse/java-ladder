package Controller;

import domain.Ladder;
import domain.LadderGame;
import domain.Player;
import domain.PlayerCount;
import domain.Players;
import domain.Prize;
import domain.Prizes;
import domain.RandomStepGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readWithRetry(this::readPlayers);
        final Prizes prizes = readWithRetry(this::readPrizes, players);
        final int height = readWithRetry(inputView::inputHeight);

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players), new RandomStepGenerator());
        outputView.printLadderMap(players, ladder, prizes);

        final LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        showGameResult(ladderGame.getPlayersWithPrize(), players);
    }

    private Prizes readPrizes(Players players) {
        List<String> prizes = inputView.inputPrizes(players.getCount());
        return Prizes.from(prizes);
    }

    private void showGameResult(Map<Player, Prize> playersWithPrize2, Players players) {
        String inputName = readWithRetry(inputView::inputSearchingPlayer);
        Player searchedPlayer = players.search(inputName);      // TODO: 재입력 적용

        if (inputName.equals("all")) {
            outputView.printGameResult(playersWithPrize2);
        }
        if (!inputName.equals("all")) {

            Prize searchedPrize = playersWithPrize2.get(searchedPlayer);
            outputView.printGameResult(searchedPrize);
            showGameResult(playersWithPrize2, players);
        }
    }

    private Players readPlayers() {
        return Players.from(inputView.inputPlayers());
    }

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(function, input);
        }
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
