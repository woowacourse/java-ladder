package laddergame.view;


import java.util.Map;
import laddergame.domain.LadderResultItem;
import laddergame.domain.PersonalName;
import laddergame.domain.game.NamesWithItem;

public class OutputView {
    public void printLadderForm(final String ladderFrom) {
        System.out.println("사다리결과");
        System.out.println(ladderFrom);
    }

    public void printResult(final LadderResultItem item) {
        System.out.println("실행결과");
        System.out.println(item.getName());
    }

    public void printTotalResult(final NamesWithItem namesWithItem) {
        System.out.println("실행결과");
        final Map<PersonalName, LadderResultItem> nameToItem = namesWithItem.getNameToItem();
        for (PersonalName name : nameToItem.keySet()) {
            System.out.printf("%s : %s%n", name.getValue(), nameToItem.get(name).getName());
        }
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
