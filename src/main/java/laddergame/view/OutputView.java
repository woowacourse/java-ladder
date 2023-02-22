package laddergame.view;


import java.util.Map;
import laddergame.domain.LadderResultItem;
import laddergame.domain.NamesWithMatchedResult;
import laddergame.domain.PersonalName;

public class OutputView {
    public void printLadderForm(final String ladderFrom) {
        System.out.println("사다리결과");
        System.out.println(ladderFrom);
    }

    public void printResult(final LadderResultItem item) {
        System.out.println("실행결과");
        System.out.println(item.getName());
    }

    public void printTotalResult(final NamesWithMatchedResult namesWithMatchedResult) {
        System.out.println("실행결과");
        final Map<PersonalName, LadderResultItem> nameToItem = namesWithMatchedResult.getNameToItem();
        for (PersonalName name : nameToItem.keySet()) {
            System.out.println(String.format("%s : %s", name.getValue(), nameToItem.get(name).getName()));
        }
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
