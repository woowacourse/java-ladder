package ladder;

import ladder.domain.*;
import ladder.view.InputView;

import java.util.List;

public class LadderGameLauncher {
    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        ResultItems resultItems = getResultItemsSizeOf(players.size());
        CrossbarGenerator randomCrossbarGenerator = new RandomCrossbarGenerator(players.size());
        Ladder ladder = generateLadderBy(randomCrossbarGenerator);

        LadderGame laddergame = new LadderGame();
        laddergame.start(players, ladder, resultItems);
    }

    private static ResultItems getResultItemsSizeOf(int numberOfPeople) {
        List<String> resultItemNames;

        try {
            resultItemNames = InputView.inputResultName();
            return new ResultItems(resultItemNames, numberOfPeople);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResultItemsSizeOf(numberOfPeople);
        }
    }

    private static Ladder generateLadderBy(CrossbarGenerator crossbarGenerator) {
        try {
            return new Ladder(getHeight(), crossbarGenerator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLadderBy(crossbarGenerator);
        }
    }

    private static int getHeight() {
        try {
            return InputView.inputHeight();
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다.");
            return getHeight();
        }
    }

    private static PlayerGroup getPlayers() {
        List<String> playerNames;

        try {
            playerNames = InputView.inputPlayerName();
            return new PlayerGroup(playerNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }
}
