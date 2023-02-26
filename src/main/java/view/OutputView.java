package view;

import domain.Ladder;
import domain.Line;
import domain.Lines;
import domain.CalculatedResults;
import domain.Players;
import domain.Player;
import domain.Result;
import domain.Results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OutputView {

    public static final String DELIMITER = "|";
    public static final String FORMAT = "%s : %s\n";

    public void printTotalLadder(Ladder ladder) {
        System.out.println("사다리 결과\n");
        printNames(ladder.getPeople());
        printLadder(ladder.getLines());
        printResults(ladder.calculateResults());
    }

    private void printNames(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf("%5s ", player.getName());
        }
        System.out.println();
    }

    private void printLadder(Lines lines) {
        for (Line line : lines.getLines()) {
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

    public void printGameResults(CalculatedResults resultMap) {
        System.out.println("\n실행 결과");
        if (!resultMap.canTryAgain()) {
            printTotalResults(resultMap);
            return;
        }
        printSingleResult(resultMap);
    }

    private void printTotalResults(CalculatedResults resultMap) {
        Map<Player, Result> map = resultMap.getResultMap();
        for (Map.Entry<Player, Result> entry : map.entrySet()) {
            System.out.printf(FORMAT, entry.getKey().getName(), entry.getValue().getResult());
        }
        System.out.println();
    }

    private void printSingleResult(CalculatedResults resultMap) {
        Result singleResult = resultMap.findSingleResult();
        System.out.println(singleResult.getResult());
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printCriticalError(Exception exception) {
        System.out.println("예기치 못한 에러가 발생했습니다.");
        System.out.println(exception.getMessage());
    }

    private enum LineType {

        GO(Boolean.TRUE, "-----"),
        STOP(Boolean.FALSE, "     ");

        private static final Map<Boolean, LineType> MAP = new HashMap<>();

        static {
            for (LineType type : values()) {
                MAP.put(type.movable, type);
            }
        }

        private final Boolean movable;
        private final String message;

        LineType(Boolean movable, String message) {
            this.movable = movable;
            this.message = message;
        }

        public static String getMessageByMovable(Boolean movable) {
            Objects.requireNonNull(movable);
            return MAP.get(movable)
                    .message;
        }
    }
}
