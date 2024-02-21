package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름 길이가 " + Name.MAX_OF_NAME_LENGTH + "글자 초과일 때 예외가 발생한다.")
    void longNameExceptionTest() {
        assertThatThrownBy(() -> new Name("zangsu"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        "[ERROR] 이름의 길이는 " + Name.MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("이름이 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름이 없습니다.");

    }
}
