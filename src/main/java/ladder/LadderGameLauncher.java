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
        OutputView.showPlayersAndLadder(players, ladder, resultItems);

        LadderingResult ladderingResult = LadderGame.start(players, ladder, resultItems);
        show(ladderingResult);
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

    private static void show(LadderingResult ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
        show(ladderingResult);
    }
}
