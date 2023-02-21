package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            LadderGame ladderGame = generateLadderGame();
            showLadderGame(ladderGame);
            ladderGame.playLadderGame();

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private LadderGame generateLadderGame() {
        List<Player> players = generatePlayers();
        List<Reward> rewards = generateRewards();
        Height height = generateHeight();

        LadderGame ladderGame = new LadderGame(players, rewards, height);
        ladderGame.generateLadder(new RandomLineCreateDecider());
        return ladderGame;
    }

    private List<Player> generatePlayers() {
        List<String> names = inputView.readNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return players;
    }

    private List<Reward> generateRewards() {
        List<String> reward = inputView.readRewards();
        List<Reward> rewards = reward.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        return rewards;
    }

    private Height generateHeight() {
        int height = inputView.readHeight();
        return new Height(height);
    }

    private void showLadderGame(LadderGame ladderGame) {
        showPlayer(ladderGame.getPlayers());
        showLadder(ladderGame.getLadder());
        showReward(ladderGame.getRewards());
    }

    private void showPlayer(List<Player> players) {
        outputView.printPlayerNames(players.stream()
                .map(Player::getPlayerName)
                .map(PlayerName::getPlayerName)
                .collect(Collectors.toList()));
    }

    private void showLadder(Ladder ladder) {
        List<Row> rows = ladder.getRows();
        for (Row row : rows) {
            outputView.printRow(row.getPoints());
        }
    }

    private void showReward(List<Reward> rewards) {
        outputView.printReward(rewards.stream()
                .map(Reward::getReward)
                .collect(Collectors.toList()));
    }
}
