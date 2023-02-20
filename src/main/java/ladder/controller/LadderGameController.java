package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String LOOK_ALL = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final LineCreateDecider lineCreateDecider;

    public LadderGameController(InputView inputView, OutputView outputView, LineCreateDecider lineCreateDecider) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lineCreateDecider = lineCreateDecider;
    }

    public void run() {
        Players players = generatePlayers();
        Rewards rewards = generateRewards(players.getSize());
        Height height = generateHeight();
        Ladder ladder = generateLadder(players, height);

        showLadderGame(players, ladder, rewards);

        Map<Player, Reward> matchingResults = generateMatchingResults(players, ladder, rewards);
        showMatchingResults(players, matchingResults);
    }

    private Players generatePlayers() {
        try {
            List<String> names = inputView.readNames();
            return new Players(names.stream()
                    .map(Player::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generatePlayers();
        }
    }

    private Rewards generateRewards(int playerCount) {
        try {
            List<Reward> rewards = inputView.readRewards().stream()
                    .map(Reward::new)
                    .collect(Collectors.toList());
            return new Rewards(rewards, playerCount);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateRewards(playerCount);
        }
    }

    private Height generateHeight() {
        try {
            int height = inputView.readHeight();
            return new Height(height);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return generateHeight();
        }
    }

    private Ladder generateLadder(Players players, Height height) {
        LadderGenerator ladderGenerator = new LadderGenerator(lineCreateDecider);
        return ladderGenerator.generateLadder(players.getSize(), height);
    }

    private void showLadderGame(Players players, Ladder ladder, Rewards rewards) {
        outputView.printLadderResultMessage();
        outputView.printPlayerNames(players.getPlayers().stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList()));

        List<Row> rows = ladder.getRows();
        rows.forEach(row -> outputView.printRow(row.getPoints()));
        outputView.printRewards(rewards.getRewards().stream()
                .map(Reward::getReward)
                .collect(Collectors.toList()));
    }

    private Map<Player, Reward> generateMatchingResults(Players players, Ladder ladder, Rewards rewards) {
        Map<Player, Reward> matchingResults = new HashMap<>();
        for (Player player : players.getPlayers()) {
            int entrance = players.findPositionOf(player);
            int exit = ladder.findExitFrom(entrance);
            Reward reward = rewards.getRewards().get(exit);
            matchingResults.put(player, reward);
        }
        return matchingResults;
    }

    private void showMatchingResults(Players players, Map<Player, Reward> matchingResults) {
        String input = inputView.readPlayerChoice();
        if (input.equals(LOOK_ALL)) {
            outputView.printAllPlayerResults(matchingResults);
            return;
        }
        showChosePlayerResult(players, matchingResults, input);
        showMatchingResults(players, matchingResults);
    }

    private void showChosePlayerResult(Players players, Map<Player, Reward> matchingResults, String input) {
        try {
            Player player = players.findPlayerByName(input);
            outputView.printChosePlayerResult(matchingResults.get(player).getReward());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            input = inputView.readPlayerChoice();
            showChosePlayerResult(players, matchingResults, input);
        }
    }

}
