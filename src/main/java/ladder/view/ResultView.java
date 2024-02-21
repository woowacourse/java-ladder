package ladder.view;

import static ladder.domain.Direction.RIGHT;

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
        int height = ladder.getHeight();
        int peopleCount = ladder.getPeopleCount();
        for (int i = 0; i < height; i++) {
            System.out.print("\t");
            for (int j = 0; j < peopleCount; j++) {
                if (ladder.getDirection(i, j) == RIGHT) {
                    System.out.print("|-----");
                    continue;
                }
                System.out.print("|     ");
            }
            System.out.println();
        }
    }
}
