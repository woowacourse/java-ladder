package view;

import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            List<Boolean> points = line.getPoints();
            List<String> collect = getHorizonLine(points);
            System.out.printf("    |%s|%n", String.join("|", collect));
        }
    }

    private List<String> getHorizonLine(List<Boolean> points) {
        List<String> collect = new ArrayList<>();
        for (Boolean point : points) {
            collect.add(LineType.GO.getByMovable(point));
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

    private enum LineType {
        GO(Boolean.TRUE, "-----"),
        STOP(Boolean.FALSE, "     ");

        private final Boolean movable;
        private final String message;

        LineType(Boolean movable, String message) {
            this.movable = movable;
            this.message = message;
        }

        public String getByMovable(Boolean movable) {
            return Arrays.stream(values())
                .filter(m -> m.getMovable().equals(movable))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 값이 없습니다."))
                .getMessage();
        }

        public Boolean getMovable() {
            return movable;
        }

        public String getMessage() {
            return message;
        }
    }
}
