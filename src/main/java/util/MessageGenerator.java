package util;

import domain.Goals;
import domain.Names;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static view.constant.LadderShapes.*;

public class MessageGenerator {

    public static String generateNamesMessage(Names names) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : names.getNames()) {
            stringBuilder.append(alignLeft(name));
        }

        return stringBuilder.toString();
    }

    public static String generateGoalsMessage(Goals goals) {
        List<String> aligned = goals.getGoalNames().stream()
                .map(MessageGenerator::alignLeft)
                .collect(Collectors.toList());
        return String.join(" ", aligned);
    }

    private static String alignLeft(final String name) {
        return String.format("%-5s", name);
    }

    public static List<String> generateLadderMessage(List<List<Boolean>> ladderInfo) {
        List<String> ladderMessage = new ArrayList<>();
        for (List<Boolean> line : ladderInfo) {
            ladderMessage.add(generateLineMessage(line));
        }
        return ladderMessage;
    }

    private static String generateLineMessage(final List<Boolean> line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean isSteppable : line) {
            printSteppableLine(stringBuilder, isSteppable);
            printUnSteppableLine(stringBuilder, isSteppable);
        }
        stringBuilder.append(PILLAR.getShape());
        return stringBuilder.toString();
    }

    private static void printUnSteppableLine(StringBuilder stringBuilder, final Boolean isSteppable) {
        if (!isSteppable) {
            stringBuilder.append(generateLineMessage(BLANK.getShape()));
        }
    }

    private static void printSteppableLine(StringBuilder stringBuilder, final Boolean isSteppable) {
        if (isSteppable) {
            stringBuilder.append(generateLineMessage(FOOTSTEP.getShape()));
        }
    }

    private static String generateLineMessage(final String shape) {
        String footSteps = shape.repeat(5);
        return String.format("%s%s", PILLAR.getShape(), footSteps);
    }
}
