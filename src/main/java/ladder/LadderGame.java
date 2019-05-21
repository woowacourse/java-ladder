package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;
import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        CrosspointGenerator randomCrosspointGenerator = new RandomCrosspointGenerator();
        ResultItems resultItems = getResultItems(players.size());
        Ladder ladder = getLadderBy(randomCrosspointGenerator, players.size());
        LadderResult ladderingResult = players.matchLadderingResult(resultItems
                , ladder.getLadderingResultItemsIndex(players.size()));

        OutputView.showPlayersAndLadder(players, ladder, resultItems);
        show(ladderingResult);
    }

    private static void show(LadderResult ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        show(ladderingResult);
    }

    private static ResultItems getResultItems(int numberOfPlayer) {
        List<String> resultNames;

        try {
            resultNames = InputView.inputResultName();
            return new ResultItems(resultNames, numberOfPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResultItems(numberOfPlayer);
        }
    }

    private static Ladder getLadderBy(CrosspointGenerator crosspointGenerator, int numberOfPlayer) {
        try {
            return new Ladder(getHeight(), crosspointGenerator, numberOfPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLadderBy(crosspointGenerator, numberOfPlayer);
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
