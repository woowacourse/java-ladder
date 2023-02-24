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
        showResultBoard(new ResultBoard(players, ladder, rewards));
    }

    private Players generatePlayers() {
        try {
            List<Player> names = inputView.readNames().stream()
                    .map(Player::new)
                    .collect(Collectors.toList());
            return new Players(names);
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
            return Rewards.of(rewards, playerCount);
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
        showPlayers(players);
        showLadder(ladder);
        showRewards(rewards);
    }

    private void showPlayers(Players players) {
        outputView.printPlayerNames(players.getPlayers().stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList()));
    }

    private void showLadder(Ladder ladder) {
        ladder.getRows().forEach(row -> outputView.printRow(row.getPoints()));
    }

    private void showRewards(Rewards rewards) {
        outputView.printRewards(rewards.getRewards().stream()
                .map(Reward::getReward)
                .collect(Collectors.toList()));
    }

    private void showResultBoard(ResultBoard resultBoard) {
        String option = inputView.readPlayerChoice();

        while (!option.equals(Command.LOOK_ALL_PLAYERS_RESULT.getCommand())) {
            showSinglePlayer(resultBoard, option);
            option = inputView.readPlayerChoice();
        }
        showAllPlayers(resultBoard);
    }

    private void showAllPlayers(ResultBoard resultBoard) {
        Map<String, String> result = new HashMap<>();
        resultBoard.getResult().forEach((key, value) -> result.put(key.getPlayerName(), value.getReward()));
        outputView.printAllPlayersResult(result);
    }

    private void showSinglePlayer(ResultBoard resultBoard, String playerName) {
        try {
            Player player = new Player(playerName);
            outputView.printSinglePlayerResult(resultBoard.getRewardOf(player).getReward());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
        }
    }

}
