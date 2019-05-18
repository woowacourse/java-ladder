package laddergame.domain;

import laddergame.domain.rule.Rule;

public class LadderGenerator {
    public static Ladder generateLadder(int numberOfPoint, int height, Rule rule) {
        Ladder ladder = new Ladder();
        for (int i = 0; i < height; i++) {
            ladder.addLines(LineGenerator.lineGenerate(numberOfPoint, rule));
        }
        return ladder;
    }
}
