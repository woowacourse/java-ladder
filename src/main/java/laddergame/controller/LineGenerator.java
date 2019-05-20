package laddergame.controller;

import laddergame.controller.rule.Rule;
import laddergame.domain.Line;

public class LineGenerator {
    public static Line lineGenerate(Rule rule, int numberOfPerson) {
        final int numberOfInterval = numberOfPerson - 1;
        Line line = new Line(numberOfPerson);

        for (int i = 0; i < numberOfInterval; i++) {
            generateScaffold(rule, line, i);
        }
        return line;
    }

    private static void generateScaffold(Rule rule, Line line, int index) {
        if (line.canAddScaffold(index) && rule.canCreate()) {
            line.addScaffold(index);
        }
    }
}
