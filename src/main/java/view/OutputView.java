package view;

import domain.Ladder;
import domain.Line;
import domain.People;
import domain.Person;
import domain.Result;
import domain.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            System.out.printf("%5s ", result.get());
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

    public void printGameResults(Map<Person, Result> resultMap) {
        if (resultMap.size() > 1) {
            System.out.println("\n실행 결과");
            for (Map.Entry<Person, Result> entry : resultMap.entrySet()) {
                System.out.printf(FORMAT, entry.getKey().getName(), entry.getValue().get());
            }
            System.out.println();
            return;
        }
        System.out.println("\n실행 결과");
        String singleResult = resultMap.values().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과가 존재하지 않습니다."))
                .get();
        System.out.println(singleResult);
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }
}
