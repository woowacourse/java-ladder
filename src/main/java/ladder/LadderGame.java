package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private static final int LAST_DUMMY_SPACE = 1;

    public static void main(String[] args) {
        PlayerGroup players = getPlayers();
        CrossbarGenerator randomCrossbarGenerator = new RandomCrossbarGenerator(players.size() + LAST_DUMMY_SPACE);
        Ladder ladder = getLadderBy(getResultItems(), randomCrossbarGenerator);
        Map<String, ResultItem> ladderingResult = players.findLadderingResult(ladder);

        OutputView.showPlayersAndLadder(players, ladder);
        show(ladderingResult);
    }

    private static void show(Map<String, ResultItem> ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf(playerName, ladderingResult);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        show(ladderingResult);
    }

    private static List<ResultItem> getResultItems() {
        List<String> resultNames;

        try {
            resultNames = InputView.inputResultName();
            return createResultItems(resultNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getResultItems();
        }
    }

    private static List<ResultItem> createResultItems(List<String> resultNames) {
        List<ResultItem> resultItems = new ArrayList<>();

        for (String resultName : resultNames) {
            resultItems.add(new ResultItem(resultName));
        }
        return resultItems;
    }

    private static Ladder getLadderBy(List<ResultItem> resultItems, CrossbarGenerator crossbarGenerator) {
        try {
            return new Ladder(getHeight(), resultItems, crossbarGenerator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLadderBy(getResultItems(), crossbarGenerator);
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
