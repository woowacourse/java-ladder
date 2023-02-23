import domain.generator.RandomBooleanGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import domain.player.Players;
import domain.result.Prizes;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Players players = readPlayers();
        Prizes prizes = readPrizes();
        Ladder ladder = createLadder(players.getPlayers().size());
        LadderGame ladderGame = LadderGame.of(players, prizes, ladder);

        showLadder(players, ladder, prizes);
        String resultName = readResultName(ladderGame);
        showResult(ladderGame, resultName);
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

    private static Prizes readPrizes() {
        try {
            List<String> prizes = InputView.readPrizes();
            return new Prizes(prizes);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readPrizes();
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

    private static String readResultName(LadderGame ladderGame) {
        try {
            String resultName = InputView.readResultName();
            validateResultName(ladderGame, resultName);
            return resultName;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readResultName(ladderGame);
        }
    }

    private static void validateResultName(LadderGame ladderGame, String resultName) {
        if (!resultName.equals("all") && !ladderGame.hasContain(resultName)) {
            throw new IllegalArgumentException("이름과 일치하는 참가자가 존재하지 않습니다.");
        }
    }

    private static void showLadder(Players players, Ladder ladder, Prizes prizes) {
        OutputView.showResultMessage();
        OutputView.showPlayers(players.getPlayers());
        OutputView.showLadder(ladder);
        OutputView.showPrizes(prizes.getPrizes());
    }

    private static void showResult(LadderGame ladderGame, String name) {
        OutputView.showGameResult(ladderGame, name);
    }
}
