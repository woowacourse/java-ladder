package domain;

import java.util.Queue;

public class CustomRandomGenerator implements BooleanGenerator {
    private final Queue<Boolean> randomNumberQueue;

    public CustomRandomGenerator(Queue<Boolean> randomNumberQueue) {
        this.randomNumberQueue = randomNumberQueue;
    }

    @Override
    public boolean get() {
        return randomNumberQueue.poll();
    }
}
