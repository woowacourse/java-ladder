package view;

import domain.model.*;

import java.util.List;
import java.util.stream.IntStream;

import static domain.model.Direction.*;

public class ResultView {
    private static final int MAX_INTERVAL = 6;
    private static final int START_POSITION = 0;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String INTERVAL = "     ";

    public void printResult(People people, Ladder ladder,Consequences consequences) {
        System.out.println("\n사다리 결과\n");
        printNames(people);
        printLadder(people.getNumberOfParticipants(), ladder);
        printConsequences(consequences);
    }

    private void printLadder(int numberOfParticipants, Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(line -> printLine(line, numberOfParticipants))
                .forEach(System.out::println);
    }

    private void printNames(People people) {
        people.getParticipants()
                .stream()
                .map(Person::getName)
                .forEach(name -> System.out.print(fillInterval(name)));

        System.out.println();
    }

    private String printLine(Line line, int personCount) {
        int points = personCount;
        StringBuilder result = new StringBuilder(INTERVAL);
        IntStream.range(0, points)
                .forEach(index -> result
                        .append(VERTICAL_LINE)
                        .append(drawHorizontalLine(line.showDirection(index))));

        return result.toString();
    }

    private String drawHorizontalLine(Direction direction) {
        if (direction == RIGHT) {
            return HORIZONTAL_LINE;
        }
        return INTERVAL;
    }

    private void printConsequences(Consequences consequences){
        consequences.getConsequences()
                .stream()
                .map(Consequence::getValue)
                .forEach((consequence)-> System.out.print(fillInterval(consequence)));
    }

    private String fillInterval(String name) {
        StringBuilder filledName = new StringBuilder(name);
        return filledName.insert(START_POSITION, " ".repeat(MAX_INTERVAL - name.length()))
                .toString();
    }

}
