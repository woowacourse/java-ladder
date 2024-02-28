package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {

    @Test
    @DisplayName("문자열을 바탕으로 경품을 생성한다.")
    void generatePrizeTest() {
        //given
        String inputText = "안녕,프람";

        //when
        Prize prize = new Prize(inputText);

        //then
        assertThat(prize).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("공백 문자열이 입력되면 예외를 발생시킨다.")
    void blankNotAllowTest(String inputText) {
        assertThatThrownBy(() -> new Prize(inputText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "helllo"})
    @DisplayName("경품 이름이 1~5자 사이가 아니면 아니면 예외 발생시킨다.")
    void prizeLengthTest(String inputText) {
        assertThatThrownBy(() -> new Prize(inputText))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
