package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.domain.NameExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class NameTest {

    @Test
    @DisplayName("이름 길이가 " + Name.MAX_OF_NAME_LENGTH + "글자 초과일 때 예외가 발생한다.")
    void longNameExceptionTest() {
        assertThatThrownBy(() -> new Name("zangsu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameExceptionMessage.OUT_OF_RANGE_NAME_LENGTH.getExceptionMessage());
    }

    @Test
    @DisplayName("이름에 종료 단어를 사용하면 예외가 발생한다.")
    void unavailableNameExceptionTest() {
        assertThatThrownBy(() -> new Name("종료"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameExceptionMessage.UNAVAILABLE_NAME.getExceptionMessage());
    }

    @ParameterizedTest
    @DisplayName("이름이 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameExceptionMessage.NO_NAME.getExceptionMessage());
    }

}
