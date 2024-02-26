package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanGeneratorTest {

    @DisplayName("true를 입력하면 반드시 false를 반환한다.")
    @Test
    void returnFalseIfTrue() {
        LadderRowElementGenerator booleanGenerator = new LadderRowElementGenerator();
        boolean result = booleanGenerator.updateFalseIfTrue(true);
        Assertions.assertThat(result).isFalse();
    }
}
