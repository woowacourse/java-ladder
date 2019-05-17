package ladder.domain.generator;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public final class SubLineRandomGenerator implements SubLineGenerator {
    private final int countOfPlayers;

    public SubLineRandomGenerator(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public List<Boolean> generate() {
        Stack<Boolean> subLines = new Stack<>();
        for (int i = 0; i < countOfPlayers - 1; i++) {
            push(subLines);
        }
        return subLines;
    }

    private void push(Stack<Boolean> subLines) {
        if (!subLines.empty() && subLines.peek()) {
            subLines.push(false);
            return;
        }
        subLines.push(randomBoolean());
    }

    private Boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
