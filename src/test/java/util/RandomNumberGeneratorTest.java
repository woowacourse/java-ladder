package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void test() {
        int i = RandomNumberGenerator.pickRandomNumberInRange(1, 1);
        assertThat(i).isGreaterThanOrEqualTo(1);
        assertThat(i).isLessThanOrEqualTo(1);
    }

}
