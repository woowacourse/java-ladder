package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private final Ladder ladder;
    private List<Integer> result = List.of();

    public Game(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<Integer> calculateResult() {
        if (result.isEmpty()) {
            result = IntStream.range(0, ladder.width() + 1)
                    .map(this::calculateOne)
                    .boxed()
                    .toList();
        }
        return result;
    }

    public int calculateOne(int startPosition) {
        return IntStream.range(0, ladder.height())
                .reduce(startPosition, this::calculateOneDepth);
    }

    public int calculateOneDepth(int position, int depth) {
        if (isFirst(position)) {
            return position + rightMovement(position, depth);
        }
        if (isLast(position)) {
            return position - leftMovement(position, depth);
        }
        return position + rightMovement(position, depth) - leftMovement(position, depth);
    }

    private boolean isFirst(int position) {
        return position == 0;
    }

    private boolean isLast(int position) {
        return position == ladder.width();
    }

    private int leftMovement(int position, int depth) {
        return ladder
                .lines().get(depth)
                .scaffolds().get(position - 1)
                .compareTo(false);
    }

    private int rightMovement(int position, int depth) {
        return ladder
                .lines().get(depth)
                .scaffolds().get(position)
                .compareTo(false);
    }
}
