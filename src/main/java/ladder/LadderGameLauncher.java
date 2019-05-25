package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameLauncher {
    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        int numberOfPlayers = players.size();
        ResultItems resultItems = getResultItems(numberOfPlayers);
        Ladder ladder = generateLadderWidthOf(numberOfPlayers);

        LadderGame laddergame = new LadderGame();
        laddergame.start(players, ladder, resultItems);
    }

    private static PlayerGroup getPlayers() {
        List<String> playerNames;

        try {
            playerNames = InputView.inputPlayerName();
            return new PlayerGroup(playerNames);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getPlayers();
        }
    }

    private static ResultItems getResultItems(int numberOfPeople) {
        List<String> resultItemNames;

        try {
            resultItemNames = InputView.inputResultName();
            return new ResultItems(resultItemNames, numberOfPeople);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getResultItems(numberOfPeople);
        }
    }

    private static Ladder generateLadderWidthOf(int width) {
        try {
            int height = getHeight();
            return new Ladder(height, width);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return generateLadderWidthOf(width);
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

}
