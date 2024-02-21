package view;

import domain.model.*;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final int MAX_INTERVAL=6;
    private static final int START_POSITION=0;
    private static final String VERTICAL_LINE="|";
    private static final String HORIZONTAL_LINE="-----";

    private static final String INTERVAL = "     ";
    public void printResult(People people, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printNames(people);

        ladder.getLines()
                .stream()
                .map(line -> printFloor2(line.findHorizontal(),people.numberOfParticipant()))
                .forEach(System.out::println);
    }



    private String printFloor2(List<Integer> indexes, int personCount){
        StringBuilder sb= new StringBuilder(INTERVAL+VERTICAL_LINE);
        IntStream.range(0, personCount-1)
                .sequential()
                .forEach(index -> sb
                        .append(drawEachLine(indexes.contains(index)))
                        .append(VERTICAL_LINE));

        return sb.toString();
    }
    private String drawEachLine(boolean hasHorizontalLine){
        if (hasHorizontalLine){
            return HORIZONTAL_LINE;
        }
        return INTERVAL;
    }
    private void printNames(People people) {
        people.getParticipant()
                .stream()
                .map(Person::getName)
                .forEach(name -> System.out.print(fillInterval(name)));
        System.out.println();
    }

    private String fillInterval(String name) {
        StringBuilder filledName = new StringBuilder(name);
        return filledName.insert(START_POSITION, " ".repeat(MAX_INTERVAL - name.length()))
                .toString();
    }

}
