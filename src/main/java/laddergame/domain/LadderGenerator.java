package laddergame.domain;

public class LadderGenerator {
    public static Ladder generateLadder(int height, int numberOfInterval, Rule rule) {
        Ladder ladder = new Ladder();
        for (int i = 0; i < height; i++) {
            ladder.addLines(LineGenerator.lineGenerate(numberOfInterval, rule));
        }
        return ladder;
    }
}
