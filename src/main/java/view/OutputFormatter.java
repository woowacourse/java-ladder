package view;

import domain.*;

import java.util.stream.Collectors;

public class OutputFormatter {
    private static final String SPACE = " ";
    private static final String BAR = "|";
    private static final String BRIDGE = "-----";

    public String toNameUnit(Players players) {
        return players.getPlayers().stream()
                .map(this::getNameUnit)
                .collect(Collectors.joining());
    }

    private String getNameUnit(Player player) {
        String name = player.getName();
        if (name.length() < 5) {
            name = String.format("%4s ", name);
        }
        return name + SPACE;
    }

    public String toLine(Line rawLine) {
        String line = rawLine.getSteps().stream()
                .map(this::getStep)
                .collect(Collectors.joining());
        return "    " + line;
    }

    private String getStep(Step step) {
        if (step.isRight()) {
            return BAR + BRIDGE;
        }
        return BAR + "     ";
    }

    public String toTargetUnit(Targets targets) {
        return targets.getTargets().stream()
                .map(this::getTargetUnit)
                .collect(Collectors.joining());
    }

    private String getTargetUnit(Target target) {
        String name = target.getTarget();
        if (name.length() < 5) {
            name = String.format("%4s ", name);
        }
        return name + SPACE;
    }

    public String toResult(Player player, Target target) {
        return player.getName() + " : " + target.getTarget();
    }
}
