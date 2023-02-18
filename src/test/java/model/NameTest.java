package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String MAXIMUM_NAME_LENGTH_ERROR = "[ERROR] 사람 최대 이름 길이는 %d 이하로만 가능합니다.";
    private static final String NAME_HAS_NON_ALPHABETIC_ERROR = "[ERROR] 사람 이름은 영문자로만 입력되어야 합니다.";

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest() {
        Assertions.assertThatNoException().isThrownBy(() -> new Name("ocean"));
    }

    @Test
    @DisplayName("이름 값 길이 제한으로 인한 Player 객체 생성 실패 테스트")
    void limitPlayerNameLengthTest() {
        assertThatThrownBy(() -> new Name("woowacourse"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(MAXIMUM_NAME_LENGTH_ERROR, MAXIMUM_NAME_LENGTH));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", " ", "@#$@", "abs@#"})
    @DisplayName("사람 이름은 문자로만 이루어져 있는지 확인하는 기능 테스트")
    void validateNameHasOnlyCharacters(String inputName) {
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_HAS_NON_ALPHABETIC_ERROR);
    }

    @Test
    @Disabled("단순 getter 메서드는 테스트하지 않는다.")
    void getName() {
    }

    @Test
    @DisplayName("사람 이름 간 비교하는 기능 테스트")
    void compareNameTest() {
        //given
        Name name = new Name("pobi");

        //then
        assertThat(name).isEqualTo(new Name("pobi"));
        assertThat(name).isNotEqualTo(new Name("neo"));
    }
}
