package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.model.ErrorMessage.EXCEPTION_RESULT_NOT_FOUND;

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
            askResults(ladderGame.getResult());
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

    private void askResults(Map<Player, Reward> result) {
        String askedPlayerName = inputView.readAskingResult();
        while (!askedPlayerName.equals("quit")) {
            searchResult(result, askedPlayerName);
            askedPlayerName = inputView.readAskingResult();
        }
        ;
    }

    private void searchResult(Map<Player, Reward> result, String askedPlayerName) {
        if (askedPlayerName.equals("quit")) {
            return;
        }
        if (askedPlayerName.equals("all")) {
            showAllResult(result);
            return;
        }

        Player askedPlayer = result.keySet().stream()
                .filter(key -> key.getPlayerName().equals(askedPlayerName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(EXCEPTION_RESULT_NOT_FOUND.getMessage()));

        showOneResult(result.get(askedPlayer));
    }

    private void showAllResult(Map<Player, Reward> result) {
        Map<String, String> convertedResult = result.keySet()
                .stream()
                .collect(Collectors.toMap(
                        Player::getPlayerName,
                        key -> result.get(key).getReward()
                ));

        outputView.printAllResult(convertedResult);
    }

    private void showOneResult(Reward reward) {
        outputView.printOneResult(reward.getReward());
    }
}
