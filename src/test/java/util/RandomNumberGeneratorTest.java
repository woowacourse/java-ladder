package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void pickRandomNumberInRangeSuccess() {
        int targetNumber = 1;
        int number = RandomNumberGenerator.pickRandomNumberInRange(targetNumber, targetNumber);
        assertThat(number).isGreaterThanOrEqualTo(targetNumber);
        assertThat(number).isLessThanOrEqualTo(targetNumber);
    }

}
