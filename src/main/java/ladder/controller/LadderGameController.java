package ladder.controller;

import ladder.exceptionMessage.ExceptionMessage;
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
        try {
            Players players = generatePlayers();
            Rewards rewards = generateRewards(players.getSize());
            Height height = generateHeight();
            Ladder ladder = generateLadder(players, height);
            showLadderGame(players, ladder, rewards);
            showResultBoard(new ResultBoard(players, ladder, rewards));
        } catch (Exception exception) {
            outputView.printExceptionMessage(ExceptionMessage.EXCEPTION_EXIT.getMessage());
        }
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

        ladder.getRows().forEach(row -> outputView.printRow(row.getPoints()));

        outputView.printRewards(rewards.getRewards().stream()
                .map(Reward::getReward)
                .collect(Collectors.toList()));
    }

    private void showResultBoard(ResultBoard resultBoard) {
        String input = inputView.readPlayerChoice();

        if (input.equals(LOOK_ALL)) {
            showAllPlayerResults(resultBoard);
            return;
        }

        showChosePlayerResult(resultBoard, input);
        showResultBoard(resultBoard);
    }

    private void showAllPlayerResults(ResultBoard resultBoard) {
        Map<String, String> results = new HashMap<>();
        resultBoard.getResult().forEach((key, value) -> results.put(key.getPlayerName(), value.getReward()));
        outputView.printAllPlayerResults(results);
    }

    private void showChosePlayerResult(ResultBoard resultBoard, String input) {
        try {
            outputView.printChosePlayerResult(resultBoard.getRewardOf(input).getReward());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            input = inputView.readPlayerChoice();
            showChosePlayerResult(resultBoard, input);
        }
    }

}
