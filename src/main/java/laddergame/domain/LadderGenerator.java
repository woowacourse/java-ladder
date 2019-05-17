package laddergame.domain;

import laddergame.domain.rule.Rule;

public class LadderGenerator {
    public static Ladder generateLadder(int height, int numberOfPerson, Rule rule) {
        Ladder ladder = new Ladder();
        for (int i = 0; i < height; i++) {
            ladder.addLines(LineGenerator.lineGenerate(numberOfPerson, rule));
        }
        return ladder;
    }
}
