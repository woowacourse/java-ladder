package laddergame.domain.ladder;

public class RandomPositionGenerator {
    private RandomPositionGenerator() {

    }

    static Position generate(final int height, final int width) {
        final int randomRow = (int) (Math.random() * height) + 1;
        final int randomCol = (int) (Math.random() * width) + 1;
        return Position.of(randomRow, randomCol);
    }
}
