package laddergame.view;

import java.util.List;
import laddergame.model.ladder.Ladder;
import laddergame.model.ladder.Point;
import laddergame.model.people.People;
import laddergame.model.people.Prizes;
import laddergame.model.people.Result;
import laddergame.model.people.Results;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String BLANK_LINE = "     ";
    private static final String LADDER_RESULT_MSG = "사다리 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadderResult(Ladder ladder, People people, Prizes prizes) {
        System.out.println(System.lineSeparator() + LADDER_RESULT_MSG + System.lineSeparator());
        printPeople(people);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printPeople(People people) {
        people.getPeople().forEach(person -> System.out.printf("%6s", person.getName()));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getSize(); i++) {
            System.out.print(BLANK_LINE);
            printLine(ladder.get(i).getLine());
            System.out.println();
        }
    }

    private void printLine(List<Point> line) {
        for (Point point : line) {
            System.out.print(VERTICAL_LINE);
            System.out.print(printPoint(point));
        }
    }

    private String printPoint(Point point) {
        if (point.getRightIsBoolean()) {
            return HORIZONTAL_LINE;
        }
        return BLANK_LINE;
    }

    private void printPrizes(Prizes prizes) {
        prizes.getPrizes().forEach(prize -> System.out.printf("%6s", prize.getPrize()));
        System.out.println();
    }

    public void printAllResult(Results results) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (Result result : results.getResults()) {
            System.out.println(result.getPerson().getName() + " : " + result.getPrize().getPrize());
        }
    }

    public void printPersonalResult(Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(result.getPrize().getPrize());
    }
}
