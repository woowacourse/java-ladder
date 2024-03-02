package controller;

import domain.*;
import util.BooleanGenerator;
import util.RetryUtil;
import view.InputView;
import view.LadderShape;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final String INPUT_SPLIT_DELIMITER = ",";
    private static final String OUTPUT_FORMAT = "%5s ";
    private static final String PRINT_ALL_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        Players players = RetryUtil.retryUntilNoException(this::makePlayers);
        Prizes prizes = RetryUtil.retryUntilNoException(() -> makePrize(players));
        Ladder ladder = RetryUtil.retryUntilNoException(() -> makeLadder(players.getPlayersCount(), booleanGenerator));

        printLadderOutput(ladder, players, prizes);

        GameResult gameResult = new GameResult();
        ladder.playLadder(gameResult, prizes, players);
        printGameResultUntilEmptyName(players, gameResult);
    }

    private Players makePlayers() {
        String input = inputView.inputName();

        List<String> names = List.of(input.split(INPUT_SPLIT_DELIMITER));

        return new Players(names);
    }

    private Prizes makePrize(Players players) {
        String input = inputView.inputResults();

        validateResultsLength(input, players.getPlayersCount());
        List<String> prizes = List.of(input.split(INPUT_SPLIT_DELIMITER));

        return new Prizes(prizes);
    }

    private void validateResultsLength(String results, int playersCount) {
        if (results.split(INPUT_SPLIT_DELIMITER).length != playersCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자 수와 동일해야 합니다.");
        }
    }

    private Ladder makeLadder(int playersCount, BooleanGenerator booleanGenerator) {
        String input = inputView.inputHeight();

        return Ladder.of(new Height(input), playersCount, booleanGenerator);
    }

    private void printLadderOutput(Ladder ladder, Players players, Prizes prizes) {
        printPlayers(players);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printPlayers(Players players) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int initPosition = 0; initPosition < players.getPlayersCount(); initPosition++) {
            String name = players.findPlayersByPosition(initPosition).getName();

            stringBuilder.append(String.format(OUTPUT_FORMAT, name));
        }

        outputView.printPlayers(stringBuilder.toString());
    }

    private void printLadder(Ladder ladder) {
        List<String> output = new ArrayList<>();

        for (Line line : ladder.getLadder()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLineOutput(line, stringBuilder);

            output.add(stringBuilder.toString());
        }

        outputView.printLadderOutput(output);
    }

    private void createLineOutput(Line line, StringBuilder stringBuilder) {
        for (LadderItem point : line.getPoints()) {
            stringBuilder.append(LadderShape.getShapeByLadderItem(point));
        }
    }

    private void printPrizes(Prizes prizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String gameResult : prizes.getPrizes()) {
            stringBuilder.append(String.format(OUTPUT_FORMAT, gameResult));
        }

        outputView.printResultsOutput(stringBuilder.toString());
    }

    private void printGameResultUntilEmptyName(Players players, GameResult gameResult) {
        boolean keepInput = true;

        while (keepInput) {
            keepInput = RetryUtil.retryUntilNoException(() -> printGameResult(players, gameResult));
        }
    }

    private boolean printGameResult(Players players, GameResult gameResult) {
        String name = inputView.inputResultName();
        boolean keepInput = !name.isEmpty();

        if (keepInput) {
            outputView.printResultsOutput(makeGameResult(name, players, gameResult));
        }

        return keepInput;
    }

    private String makeGameResult(String name, Players players, GameResult gameResult) {
        if (name.equals(PRINT_ALL_COMMAND)) {
            return makeAllGameResult(gameResult);
        }

        Player player = players.findPlayersByName(name);

        return gameResult.getResultByPlayer(player);
    }

    private String makeAllGameResult(GameResult gameResult) {
        List<String> allResult = new ArrayList<>();

        for (Map.Entry<Player, String> result : gameResult.getPlayersResult().entrySet()) {
            allResult.add(result.getKey().getName() + " : " + result.getValue());
        }

        return String.join("\n", allResult);
    }
}
