package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultCalculator {

    public static Result calculate(Players players, Map<Level, Line> lines) {
        return players.getNames().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(),
                                name -> calculatePlayerPosition(players.getPositionOf(name), lines)),
                        Result::new));
    }

    private static int calculatePlayerPosition(int position, Map<Level, Line> lines) {
        for (Line line : lines.values()) {
            position = line.calculatePosition(position);
        }
        return position;
    }
}
