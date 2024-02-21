package ladder.view;

import static ladder.domain.Direction.RIGHT;

import java.util.StringJoiner;

import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.People;

public class ResultView {

    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";

    public static void printResult(People people, Ladder ladder) {
        printPeople(people);
        printLadder(ladder);
    }

    private static void printPeople(People people) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        people.stream().forEach(name -> stringJoiner.add(NAME_FORMAT.formatted(name)));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        for (int currentHeight = 0; currentHeight < ladder.getHeight(); currentHeight++) {
            printLadderLevel(ladder, currentHeight);
            System.out.println();
        }
    }

    private static void printLadderLevel(Ladder ladder, int currentHeight) {
        System.out.print("\t");
        for (int personIndex = 0; personIndex < ladder.getPeopleCount(); personIndex++) {
            printLineIfPresent(ladder.getDirection(currentHeight, personIndex));
        }
    }

    private static void printLineIfPresent(Direction direction) {
        if (direction == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
