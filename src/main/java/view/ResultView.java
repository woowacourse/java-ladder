package view;

import java.util.List;
import java.util.stream.IntStream;
import model.Ladder;
import model.People;
import model.Person;

public class ResultView {
    private static final int MAX_INTERVAL = 6;
    private static final int START_POSITION = 0;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String INTERVAL = "     ";

    public void printResult(People people, Ladder ladder) {
        System.out.printf("%n실행결과%n");
        printNames(people);

        ladder.getLines()
                .stream()
                .map(line -> printLine(line.findHorizontalPosition(), people.getParticipantsSize()))
                .forEach(System.out::println);
    }


    private String printLine(List<Integer> indexes, int personCount) {
        int maxHorizontalLines = personCount - 1;
        StringBuilder line = new StringBuilder(INTERVAL + VERTICAL_LINE);
        IntStream.range(0, maxHorizontalLines)
                .forEach(index -> line
                        .append(drawHorizontalLine(indexes.contains(index)))
                        .append(VERTICAL_LINE));

        return line.toString();
    }

    private String drawHorizontalLine(boolean hasHorizontalLine) {
        if (hasHorizontalLine) {
            return HORIZONTAL_LINE;
        }
        return INTERVAL;
    }

    private void printNames(People people) {
        for (Person participant : people.getParticipants()) {
            String name = participant.getName();
            printNameInterval(name);
            System.out.print(name);
        }
        System.out.println();
    }

    private void printNameInterval(String name) {
        for (int i = 0; i < MAX_INTERVAL - name.length(); i++) {
            System.out.print(" ");
        }
    }

}
