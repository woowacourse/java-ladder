package ladder.view;

import static ladder.domain.Direction.RIGHT;

import java.util.StringJoiner;

import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.LadderLevel;
import ladder.domain.People;

public class ResultView {

    private static final String NAME_DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public static void printResult(People people, Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPeople(people);
        printLadder(ladder);
    }

    private static void printPeople(People people) {
        StringJoiner stringJoiner = new StringJoiner(NAME_DELIMITER);
        people.stream().forEach(person -> stringJoiner.add(NAME_FORMAT.formatted(person.name())));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.stream().forEach(ResultView::printLadderLevel);
    }

    private static void printLadderLevel(LadderLevel ladderLevel) {
        System.out.print("\t");
        ladderLevel.stream().forEach(ResultView::printLine);
        System.out.println();
    }

    private static void printLine(Direction direction) {
        if (direction == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
