package view;

import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static final String DELIMITER = "|";

    public void printNames(List<String> names) {
        names.forEach((name) -> System.out.printf("%5s ", name));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            List<String> collect = getHorizonLine(line.getPoints());
            System.out.printf("    |%s|%n", String.join(DELIMITER, collect));
        }
    }

    private List<String> getHorizonLine(List<Boolean> points) {
        List<String> collect = new ArrayList<>();
        for (Boolean point : points) {
            collect.add(LineType.getMessageByMovable(point));
        }
        return collect;
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }
}
