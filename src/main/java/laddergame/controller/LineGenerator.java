package laddergame.controller;

import laddergame.controller.rule.Rule;
import laddergame.domain.Line;

public class LineGenerator {
    public static Line lineGenerate(final Rule rule, final int numberOfPerson) {
        final int numberOfInterval = numberOfPerson - 1;
        Line line = new Line(numberOfPerson);

        for (int i = 0; i < numberOfInterval; i++) {
            generateScaffold(rule, line, i);
        }
        return line;
    }

    private static void generateScaffold(final Rule rule, final Line line, final int index) {
        if (line.canAddScaffold(index) && rule.canCreate()) {
            line.addScaffold(index);
        }
    }
}
