package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LadderGame {
    private static final int LAST_DUMMY_SPACE = 1;

    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        ResultItems resultItems = getResultItemsof(players.size());
        CrossbarGenerator randomCrossbarGenerator = new RandomCrossbarGenerator(players.size() + LAST_DUMMY_SPACE);
        Ladder ladder = getLadderBy(randomCrossbarGenerator);

        OutputView.showPlayersAndLadder(players, ladder, resultItems);

        HashMap<String, ResultItem> ladderingResult = ladder.startLadderGame(players, resultItems);

        while(true) {
            showLadderingResult(ladderingResult);
        }
    }

    private static void showLadderingResult(HashMap<String, ResultItem> ladderingResult) {
        try {
            OutputView.showladderingResult(ladderingResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            showLadderingResult(ladderingResult);
        }
    }


    private static ResultItems getResultItemsof(int numberOfPlayers) {
        List<String> resultNames;

        try {
            resultNames = InputView.inputResultName();
            return new ResultItems(resultNames, numberOfPlayers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResultItemsof(numberOfPlayers);
        }
    }

    private static Ladder getLadderBy(CrossbarGenerator crossbarGenerator) {
        try {
            return new Ladder(getHeight(), crossbarGenerator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLadderBy(crossbarGenerator);
        }
    }

    private static int getHeight() {
        try {
            return Integer.parseInt(InputView.inputHeight());
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
