package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Game {
    private final People people;
    private final Ladder ladder;
    private final Prizes prizes;
    private final Map<String, String> result;

    public Game(People people, Ladder ladder, Prizes prizes) {
        this.people = people;
        this.ladder = ladder;
        this.prizes = prizes;
        this.result = new HashMap<>();
    }

    public Map<String, String> run() {
        List<Integer> pairs = calculateStartToEnd();

        for (int i = 0; i < pairs.size(); i++) {
            String name = people.getName(i);
            String prize = prizes.getName(pairs.get(i));
            result.put(name, prize);
        }

        return result;
    }

    List<Integer> calculateStartToEnd() {
        return IntStream.range(0, ladder.width() + 1)
                .map(this::calculateOne)
                .boxed()
                .toList();
    }

    int calculateOne(int startPosition) {
        return IntStream.range(0, ladder.height())
                .reduce(startPosition, this::calculateOneDepth);
    }

    int calculateOneDepth(int position, int depth) {
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
                .getLines().get(depth)
                .scaffolds().get(position - 1)
                .compareTo(false);
    }

    private int rightMovement(int position, int depth) {
        return ladder
                .getLines().get(depth)
                .scaffolds().get(position)
                .compareTo(false);
    }
}
