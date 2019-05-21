package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumbersTest {
    @Test
    void 더하기() {
        List<Positive> positives = Arrays.asList(new Positive(1), new Positive(2), new Positive(3));
        PositiveNumbers positiveNumbers = new PositiveNumbers(positives);

        assertThat(positiveNumbers.sum()).isEqualTo(new Positive(6));
    }
}
