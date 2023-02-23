package util;

import domain.ladder.Line;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static view.constant.LadderShapes.*;

public class MessageGenerator {

    private MessageGenerator() {
    }

    public static String generateNamesMessage(Iterator<String> playerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        while (playerNames.hasNext()) {
            String name = playerNames.next();
            stringBuilder.append(alignLeft(name));
        }
        return stringBuilder.toString();
    }

    public static String generateGoalsMessage(Iterator<String> goalNames) {
        List<String> alignedGoalNames = new ArrayList<>();
        while (goalNames.hasNext()) {
            alignedGoalNames.add(MessageGenerator.alignLeft(goalNames.next()));
        }
        return String.join(" ", alignedGoalNames);
    }

    private static String alignLeft(final String name) {
        return String.format("%-5s", name);
    }

    public static List<String> generateLadderMessage(Iterator<Iterator<Boolean>> connectedConditions) {
        List<String> ladderMessage = new ArrayList<>();
        while (connectedConditions.hasNext()) {
            ladderMessage.add(generateLineMessage(connectedConditions.next()));
        }
        return ladderMessage;
    }

    private static String generateLineMessage(final Iterator<Boolean> connectedConditions) {
        StringBuilder stringBuilder = new StringBuilder();
        while (connectedConditions.hasNext()) {
            generateStepMessage(connectedConditions, stringBuilder);
        }
        stringBuilder.append(PILLAR.getShape());
        return stringBuilder.toString();
    }

    private static void generateStepMessage(Iterator<Boolean> connectedConditions, StringBuilder stringBuilder) {
        Boolean connectedCondition = connectedConditions.next();
        if (connectedConditions.hasNext()) {
            generateConnectedStep(stringBuilder, connectedCondition);
            generateUnConnectedStep(stringBuilder, connectedCondition);
        }
    }

    private static void generateUnConnectedStep(StringBuilder stringBuilder, final Boolean connected) {
        if (!connected) {
            stringBuilder.append(generateLineMessage(BLANK.getShape()));
        }
    }

    private static void generateConnectedStep(StringBuilder stringBuilder, final Boolean connected) {
        if (connected) {
            stringBuilder.append(generateLineMessage(FOOTSTEP.getShape()));
        }
    }

    private static String generateLineMessage(final String shape) {
        String footSteps = shape.repeat(Line.BRIDGE_LENGTH);
        return String.format("%s%s", PILLAR.getShape(), footSteps);
    }
}
