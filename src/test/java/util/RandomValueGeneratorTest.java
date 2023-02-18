package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class RandomValueGeneratorTest {

    @DisplayName("True 또는 False가 반환되어야 한다.")
    @Test
    void 참_또는_거짓() {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        assertThat(randomValueGenerator.getRandomValue())
                .isExactlyInstanceOf(Boolean.class);
    }

}
