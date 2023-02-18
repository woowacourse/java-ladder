package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
class RandomValueGeneratorTest {

    @DisplayName("Random 값은 True 또는 False로 반환되어야 한다.")
    @Test
    void 참_혹은_거짓() {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        assertThat(randomValueGenerator.generate()).isExactlyInstanceOf(Boolean.class);
    }

}