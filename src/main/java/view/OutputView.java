package view;

import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
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
            List<String> lineShape = getLineShape(line.getMovements());
            System.out.printf("    |%s|%n", String.join(DELIMITER, lineShape));
        }
    }

    private List<String> getLineShape(List<Boolean> points) {
        List<String> lineShape = new ArrayList<>();
        for (Boolean point : points) {
            lineShape.add(LineType.getMessageByMovable(point));
        }
        return lineShape;
    }

    public void printError(Exception exception) {
        System.out.printf("[ERROR] : %s%n", exception.getMessage());
    }

    public void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }

    public void printResult(LadderResults ladderResults) {
        System.out.println("실행결과");
        if (ladderResults.isSingleResult()) {
            printSingleResult(ladderResults);
            return;
        }
        for (LadderResult ladderResult : ladderResults) {
            System.out.printf("%s : %s%n", ladderResult.getPersonName(),
                ladderResult.getPrize());
        }
    }

    private void printSingleResult(LadderResults ladderResults) {
        LadderResult singleResult = ladderResults.getSingleResult();
        System.out.println(singleResult.getPrize());
    }
}
