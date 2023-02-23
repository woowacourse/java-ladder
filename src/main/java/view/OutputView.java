package view;

import domain.Column;
import domain.Ladder;
import domain.Line;
import domain.People;
import domain.Person;
import domain.Result;
import domain.Results;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static final String DELIMITER = "|";
    public static final String FORMAT = "%s : %s\n";

    public void printTotalLadder(People people, Results results, Ladder ladder) {
        System.out.println("사다리 결과\n");
        printNames(people);
        printLadder(ladder);
        printResults(results);
    }

    private void printNames(People people) {
        for (Person person : people.getPeople()) {
            System.out.printf("%5s ", person.getName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            List<String> collect = getHorizonLine(line.getMovements());
            System.out.printf("    |%s|%n", String.join(DELIMITER, collect));
        }
    }

    private void printResults(Results results) {
        for (Result result : results.getResults()) {
            System.out.printf("%5s ", result.getResult());
        }
        System.out.println();
    }

    private List<String> getHorizonLine(List<Boolean> points) {
        List<String> collect = new ArrayList<>();
        for (Boolean point : points) {
            collect.add(LineType.getMessageByMovable(point));
        }
        return collect;
    }

    public void printGameResults(People people, Results results) {
        if (!results.canTryAgain()) {
            printAllResults(people, results);
            return;
        }
        printSingleResult(results);
    }

    public void printAllResults(People people, Results results) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < people.getCount(); i++) {
            System.out.printf(FORMAT, people.getByIndex(i).getName(), results.getResultByColumn(Column.of(i)).getResult());
        }
        System.out.println();
    }

    public void printSingleResult(Results results) {
        System.out.println("\n실행 결과");
        System.out.println(results.getSingleResult().getResult());
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }
}
