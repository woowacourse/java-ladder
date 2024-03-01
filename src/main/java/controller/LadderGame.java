package controller;

import domain.Height;
import domain.Ladder;
import domain.Player;
import domain.Players;
import domain.Prizes;
import view.LadderView;
import util.LineItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LadderGame {

    private static final String ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final LineItemGenerator lineItemGenerator;

    public LadderGame(InputView inputView, OutputView outputView, LineItemGenerator lineItemGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineItemGenerator = lineItemGenerator;
    }

    public void start() {
        Players players = retryUntilSuccess(this::preparePlayers);
        Prizes prizes = retryUntilSuccess(() -> inputPrizes(players.getPlayerCount()));
        Height height = retryUntilSuccess(this::inputHeight);

        Ladder ladder = Ladder.of(height, players.getPlayerCount(), lineItemGenerator);
        printLadder(players, ladder, prizes);

        String input = "";
        while (!input.equals(ALL_COMMAND)) {
            input = retryUntilSuccess(() -> inputView.inputPlayerName(players.getPlayerNames()));
            printLadderGameResult(ladder, players, prizes, input);
        }
    }

    private Players preparePlayers() {
        String input = inputView.inputName();
        List<String> names = List.of(input.split(","));
        return new Players(names);
    }

    private Prizes inputPrizes(int playerCount) {
        String input = inputView.inputPrizes();
        List<String> prizes = List.of(input.split(","));
        return new Prizes(prizes, playerCount);
    }

    private Height inputHeight() {
        return new Height(inputView.inputHeight());
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        outputView.printLadderResultMessage();
        outputView.printLadderResult(players.getPlayerNames(),
                LadderView.createLadder(ladder.getLadder()), prizes.getPrizes());
    }

    private void printLadderGameResult(Ladder ladder, Players players, Prizes prizes, String input) {
        outputView.printResultMessage();

        if (input.equals(ALL_COMMAND)) {
            printAllPlayerResults(ladder, players, prizes);
            return;
        }

        printPlayerResult(ladder, players, prizes, input);
    }

    private void printAllPlayerResults(Ladder ladder, Players players, Prizes prizes) {
        Map<String, String> results = new HashMap<>();
        for (Player player : players.getPlayers()) {
            String name = player.getName();
            int resultPosition = ladder.playLadderGame(players.findPositionOfPlayer(name));
            results.put(name, prizes.findPrizeByPosition(resultPosition));
        }
        outputView.printAllPlayerResults(results);
    }

    private void printPlayerResult(Ladder ladder, Players players, Prizes prizes, String name) {
        int resultPosition = ladder.playLadderGame(players.findPositionOfPlayer(name));
        outputView.printPlayerResult(prizes.findPrizeByPosition(resultPosition));
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
