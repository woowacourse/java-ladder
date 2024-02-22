package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;

import java.util.List;
import java.util.StringJoiner;

/*
실행결과

 pobi honux crong    jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
 */
public class OutputView {
    private static final String EXECUTION_RESULT = "실행결과";
    private static final String LADDER_SCAFFOLD = "-----";
    private static final String LADDER_BLANK = "     ";

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(People people, Ladder ladder) {
        printResultTitle();
        printPeopleNames(people);
        printLadder(ladder);
    }

    private static void printResultTitle() {
        System.out.println(EXECUTION_RESULT);
    }

    private static void printPeopleNames(People people) {
        // TODO: Optional Warning 체크
        System.out.println(
                people.getNames().stream()
                        .map(name -> String.format("%5s", name))
                        .reduce((a, b) -> a + " " + b)
                        .get());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getScaffolds().forEach(OutputView::printLine);
    }

    private static void printLine(List<Boolean> line) {
        // TODO: 매직넘버 분리
        StringJoiner joiner = new StringJoiner("|", "    |", "|");
        line.forEach(exist -> joiner.add(selectScaffold(exist)));
        System.out.println(joiner);
    }

    private static String selectScaffold(Boolean exist) {
        if (exist) {
            return LADDER_SCAFFOLD;
        }

        return LADDER_BLANK;
    }
}
