package ladder.view;

import static ladder.domain.Direction.RIGHT;

import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.People;

public class ResultView {

    public static void printResult(People people, Ladder ladder) {
        printPeople(people);
        printLadder(ladder);
    }

    private static void printPeople(People people) {
        people.stream().forEach(name -> System.out.print(name + "\t"));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        for (int currentHeight = 0; currentHeight < ladder.getHeight(); currentHeight++) {
            printLine(ladder, currentHeight);
            System.out.println();
        }
    }

    private static void printLine(Ladder ladder, int currentHeight) {
        System.out.print("\t");
        for (int personIndex = 0; personIndex < ladder.getPeopleCount(); personIndex++) {
            printDirections(ladder.getDirection(currentHeight, personIndex));
        }
    }

    private static void printDirections(Direction direction) {
        if (direction == RIGHT) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
    }
}
