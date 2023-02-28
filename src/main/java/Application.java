import domain.generator.RandomBooleanGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import domain.result.Prizes;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Players players = readPlayers();
        Prizes prizes = readPrizes(players.getSize());
        Ladder ladder = createLadder(players.getSize());

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        Map<String, String> gameResult = ladderGame.start();

        showLadder(ladderGame.getPlayers(), ladderGame.getLadder(), ladderGame.getPrizes());
        String resultName = readResultName(gameResult);
        showResult(gameResult, resultName);
    }

    private static Players readPlayers() {
        try {
            List<String> names = InputView.readNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readPlayers();
        }
    }

    private static Prizes readPrizes(int playerSize) {
        try {
            List<String> prizes = InputView.readPrizes();
            validatePrizes(prizes, playerSize);
            return new Prizes(prizes);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readPrizes(playerSize);
        }
    }

    private static void validatePrizes(List<String> prizes, int playerSize) {
        if (prizes.size() != playerSize) {
            throw new IllegalArgumentException("참가자 수와 상품 수는 일치해야 합니다.");
        }
    }

    private static Ladder createLadder(int personCount) {
        try {
            int height = InputView.readLadderHeight();
            return new Ladder(personCount, height, new RandomBooleanGenerator());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return createLadder(personCount);
        }
    }

    private static String readResultName(Map<String, String> gameResult) {
        try {
            String resultName = InputView.readResultName();
            validateResultName(gameResult, resultName);
            return resultName;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readResultName(gameResult);
        }
    }

    private static void validateResultName(Map<String, String> gameResult, String resultName) {
        if (!resultName.equals("all") && !gameResult.containsKey(resultName)) {
            throw new IllegalArgumentException("이름과 일치하는 참가자가 존재하지 않습니다.");
        }
    }

    private static void showLadder(List<Player> players, List<Line> ladder, List<String> prizes) {
        OutputView.showResultMessage();
        OutputView.showPlayers(players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList()));
        OutputView.showLadder(ladder);
        OutputView.showPrizes(prizes);
    }

    private static void showResult(Map<String, String> gameResult, String name) {
        OutputView.showGameResult(gameResult, name);
    }
}
