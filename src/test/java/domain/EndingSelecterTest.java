package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EndingSelecterTest {

    @DisplayName("대소문자 구분없이 all이면 false를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"all", "aLl", "alL", "ALL"})
    void isNotEndFalseTest(String value) {
        EndingSelecter endingSelecter = new EndingSelecter(value);
        Assertions.assertThat(endingSelecter.isNotEnd()).isFalse();
    }

    @DisplayName("all이 아니면 true를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "abc", "def", "exit"})
    void isNotEndTrueTest(String value) {
        EndingSelecter endingSelecter = new EndingSelecter(value);
        Assertions.assertThat(endingSelecter.isNotEnd()).isTrue();
    }
}
