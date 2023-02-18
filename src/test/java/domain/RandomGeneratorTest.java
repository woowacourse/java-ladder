package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;

public class RandomGeneratorTest {
    @Test
    void generateRandomNumbers() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(true, false, false, true, false, false).forEach(randomNumber::add);
        Supplier<Boolean> customRandomGenerator = new CustomRandomGenerator(randomNumber);

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < randomNumber.size(); i++) {
            result.add(customRandomGenerator.get());
        }

        Assertions.assertThat(result).isEqualTo(randomNumber);
    }

    public class CustomRandomGenerator implements Supplier<Boolean> {
        private final Queue<Boolean> randomNumberQueue;

        public CustomRandomGenerator(Queue<Boolean> randomNumberQueue) {
            this.randomNumberQueue = randomNumberQueue;
        }

        @Override
        public Boolean get() {
            return randomNumberQueue.poll();
        }
    }
}
