package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    void generateRandomNumbers() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(true, false, false, true, false, false).forEach(randomNumber::add);
        BooleanGenerator customRandomGenerator = new CustomRandomGenerator(randomNumber);

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < randomNumber.size(); i++) {
            result.add(customRandomGenerator.get());
        }

        assertThat(result).isEqualTo(randomNumber);
    }
}
