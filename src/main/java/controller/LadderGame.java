package controller;

import domain.Height;
import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Prizes;
import view.LineItem;
import util.LineItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LadderGame {

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
        Prizes prizes = retryUntilSuccess(() -> inputLadderResults(players.getPlayersCount()));
        Height height = retryUntilSuccess(this::inputHeight);

        Ladder ladder = Ladder.of(height, players.getPlayersCount(), lineItemGenerator);
        printLadder(ladder, players, prizes);

        printLadderGameResult(ladder, players, prizes);
    }

    private Players preparePlayers() {
        String input = inputView.inputName();
        List<String> names = List.of(input.split(","));

        return new Players(names);
    }

    private Prizes inputLadderResults(int columnLength) {
        String input = inputView.inputPrizes();
        List<String> ladderResults = List.of(input.split(","));
        return new Prizes(ladderResults, columnLength);
    }

    private Height inputHeight() {
        return new Height(inputView.inputHeight());
    }

    private void printLadder(Ladder ladder, Players players, Prizes prizes) {
        List<String> result = new ArrayList<>();
        List<Line> createdLadder = ladder.getLadder();

        createPlayersLineUp(result, players.getPlayers());
        createLadder(result, createdLadder);
        createLadderResults(result, prizes.getPrizes());

        outputView.printLadderResultMessage();
        outputView.printLadder(result);
    }

    private void createPlayersLineUp(List<String> result, List<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (Player player : players) {
            stringBuilder.append(String.format("%5s ", player.getName()));
        }

        result.add(stringBuilder.toString());
    }

    private void createLadder(List<String> result, List<Line> createdLadder) {
        for (Line line : createdLadder) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLine(line, stringBuilder);

            result.add(stringBuilder.toString());
        }
    }

    private void createLadderResults(List<String> result, List<String> ladderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ladderResult : ladderResults) {
            stringBuilder.append(String.format("%5s ", ladderResult));
        }

        result.add(stringBuilder.toString());
    }

    private void createLine(Line line, StringBuilder stringBuilder) {
        for (LineItem point : line.getLineItems()) {
            stringBuilder.append(point.getShape());
        }
    }

    private void printLadderGameResult(Ladder ladder, Players players, Prizes prizes) {
        String input = retryUntilSuccess(() -> inputView.inputPlayerName(players.getPlayerNames()));

        outputView.printResultMessage();
        if (input.equals("all")) {
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
