package laddergame.domain;

import laddergame.domain.Line;
import laddergame.domain.rule.Rule;

public class LineGenerator {
    public static Line lineGenerate(int numberOfPerson, Rule rule) {
        final int numberOfInterval = numberOfPerson - 1;
        Line line = new Line(numberOfPerson);

        for (int i = 1; i <= numberOfInterval; i++) {
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
