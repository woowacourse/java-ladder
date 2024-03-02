package controller;

import domain.Command;
import domain.Height;
import domain.Ladder;
import domain.PlayerResults;
import domain.Players;
import domain.Prizes;
import view.LadderView;
import util.LineItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class LadderGame {

    private static final String ERROR_PLAYER_NAME_IS_NOT_EXISTED = "참여자 목록에 없는 이름입니다.";

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

        PlayerResults playerResults = PlayerResults.of(players, ladder, prizes);

        String input = "";
        while (!Command.isAllCommand(input)) {
            input = retryUntilSuccess(() -> inputPlayerName(playerResults));
            printPlayerResult(playerResults, input);
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

    private String inputPlayerName(PlayerResults playerResults) {
        String input = inputView.inputPlayerName();

        if (playerResults.hasResult(input)) {
            return input;

        }
        throw new IllegalArgumentException(ERROR_PLAYER_NAME_IS_NOT_EXISTED);
    }

    private void printPlayerResult(PlayerResults playerResults, String input) {
        outputView.printResultMessage();

        if (Command.isAllCommand(input)) {
            outputView.printAllPlayerResults(playerResults.getPlayerResults());
            return;
        }

        outputView.printPlayerResult(playerResults.findPlayerResultByPlayer(input).getPrize());
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
