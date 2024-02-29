package domain;

import static domain.Participants.Name.MAX_OF_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Participants.Name;
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
                .hasMessage("[ERROR] 이름의 길이는 " + MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름에 종료 단어를 사용하면 예외가 발생한다.")
    void unavailableNameExceptionTest() {
        assertThatThrownBy(() -> new Name("종료"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에는 종료 키워드를 사용할 수 없습니다.");
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
