package laddergame.view;


import java.util.List;
import laddergame.domain.LadderResultItem;
import laddergame.domain.game.GameResult;

public class OutputView {
    public void printLadderForm(final String ladderFrom) {
        System.out.println("사다리결과");
        System.out.println(ladderFrom);
    }

    public void printResult(final LadderResultItem item) {
        System.out.println("실행결과");
        System.out.println(item.getName());
    }

    public void printTotalResult(final GameResult gameResult) {
        System.out.println("실행결과");

        final List<List<String>> nameAndResultItems = gameResult.getResultItemsWithName();
        nameAndResultItems.forEach(nameAndResultItem ->
                System.out.printf("%s : %s%n", nameAndResultItem.get(0), nameAndResultItem.get(1)));
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
