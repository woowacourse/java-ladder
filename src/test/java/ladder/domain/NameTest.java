package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @Test
    @DisplayName("이름을 받아서 검증 후 Name을 생성한다.")
    void generateTest() {
        String name = "pobi";
        Assertions.assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"seongha", "hongsul", "kokodak"})
    @DisplayName("참여자 이름이 1자 이상 5자 이하가 아니면 예외 처리한다.")
    void validateLengthTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자의 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("참여자 이름이 공백이면 예외 처리한다.")
    void validateBlankTest() {
        String name = "";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여자의 이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getterTest() {
        String initName = "seong";
        Name name = new Name(initName);

        assertThat(name.getRawName()).isEqualTo(initName);
    }
}
