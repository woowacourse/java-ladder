package domain;

import constant.domain.NameExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름 길이가 " + Name.MAX_OF_NAME_LENGTH + "글자 초과일 때 예외가 발생한다.")
    void longNameExceptionTest() {
        assertThatThrownBy(() -> new Name("zangsu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameExceptionMessage.OUT_OF_RANGE_NAME_LENGTH.getExceptionMessage());
    }

    @ParameterizedTest
    @DisplayName("이름이 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NameExceptionMessage.NO_NAME.getExceptionMessage());
    }

    @ParameterizedTest(name = "{0}가 이름이면 예외가 발생한다.")
    @ValueSource(strings = {"all", "exit"})
    void forbidNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] all 또는 exit는 이름이 될 수 없습니다.");
    }

}
