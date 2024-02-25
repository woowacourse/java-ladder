package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameOperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"'a',false", "'all',true"})
    @DisplayName("isAll 메서드 검증")
    void isAll(String rawOperator, boolean expected) {
        LadderGameOperator all = new LadderGameOperator(rawOperator);
        Assertions.assertThat(all.isAll())
                .isEqualTo(expected);
    }
}
