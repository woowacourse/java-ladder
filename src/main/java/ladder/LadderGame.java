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
        Ladder ladder = getLadderBy(getResultItems(), randomCrossbarGenerator);
        LadderResult ladderingResult = players.findLadderingResult(ladder);

        OutputView.showPlayersAndLadder(players, ladder);
        show(ladderingResult);
    }

    private static void show(LadderResult ladderingResult) {
        try {
            String playerName = InputView.inputPlayerNameToShowResult();
            OutputView.showResultOf2(playerName, ladderingResult);
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
