package util;

import domain.Names;

import java.util.ArrayList;
import java.util.List;

import static view.constant.LadderShapes.*;

public class MessageGenerator {

    public static String generateNamesMessage(Names names) {
        int maxNameLength = names.findMaxNameLength();
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : names.getNames()) {
            stringBuilder.append(alignLeft(name, maxNameLength));
        }

        return stringBuilder.toString();
    }

    private static String alignLeft(final String name, final int length) {
        return String.format("%-" + length + "s ", name);
    }

    public static List<String> generateLadderMessage(List<List<Boolean>> ladderInfo, int maxNameLength) {
        List<String> ladderMessage = new ArrayList<>();
        for (List<Boolean> line : ladderInfo) {
            ladderMessage.add(generateLineMessage(line, maxNameLength));
        }
        return ladderMessage;
    }

    private static String generateLineMessage(final List<Boolean> line, final int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean isSteppable : line) {
            printSteppableLine(stringBuilder, maxLength, isSteppable);
            printUnSteppableLine(stringBuilder, maxLength, isSteppable);
        }
        stringBuilder.append(PILLAR.getShape());
        return stringBuilder.toString();
    }

    private static void printUnSteppableLine(StringBuilder stringBuilder, final int maxLength, final Boolean isSteppable) {
        if (!isSteppable) {
            stringBuilder.append(generateLineMessage(BLANK.getShape(), maxLength));
        }
    }

    private static void printSteppableLine(StringBuilder stringBuilder, final int maxLength, final Boolean isSteppable) {
        if (isSteppable) {
            stringBuilder.append(generateLineMessage(FOOTSTEP.getShape(), maxLength));
        }
    }

    private static String generateLineMessage(final String shape, final int maxLength) {
        String footSteps = shape.repeat(maxLength);
        return String.format("%s%s", PILLAR.getShape(), footSteps);
    }
}
