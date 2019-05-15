package laddergame.domain;

public class LineGenerator {
    public static Line lineGenerate(int numberOfInterval, Rule rule) {
        Line line = new Line();
        for (int i = 0; i < numberOfInterval; i++) {
            generateScaffold(rule, line);
        }
        System.out.println(line);
        return line;
    }

    private static void generateScaffold(Rule rule, Line line) {
        if (line.canAddTrueScaffold()) {
            line.addScaffold(rule.canCreate());
            return;
        }
        line.addScaffold(false);
    }
}
