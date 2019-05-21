package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        CrossbarGenerator randomCrossbarGenerator = new RandomCrossbarGenerator(players.size());
        ResultItems resultItems = getResultItems(players.size());
        Ladder ladder = getLadderBy(randomCrossbarGenerator);
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

    private static List<ResultItem> createResultItems(List<String> resultNames) {
        List<ResultItem> resultItems = new ArrayList<>();

        for (String resultName : resultNames) {
            resultItems.add(new ResultItem(resultName));
        }
        return resultItems;
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
