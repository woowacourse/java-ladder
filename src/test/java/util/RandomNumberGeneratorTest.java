package util;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    void pickRandomNumberInRangeSuccess() {
        int targetNumber = 1;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new SecureRandom());

        int number = randomNumberGenerator.pickRandomNumberInRange(targetNumber, targetNumber);

        assertThat(number).isGreaterThanOrEqualTo(targetNumber);
        assertThat(number).isLessThanOrEqualTo(targetNumber);
    }

}
