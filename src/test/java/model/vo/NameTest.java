package model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 플레이어 이름을 Wrapping하는 클래스.
 * 원시타입 데이터의 getter는 테스트하지 않는다.
 */
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
    void validateNameHasOnlyCharactersTest(String inputName) {
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_HAS_NON_ALPHABETIC_ERROR);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:pobi:true", "pobi:neo:false"}, delimiter = ':')
    @DisplayName("사람 이름 간 비교 기능 테스트")
    void isSameTest(String name1, String name2, boolean answer) {
        //given
        Name name = new Name(name1);
        Name otherName = new Name(name2);

        //when
        boolean result = name.isSame(otherName);

        //then
        assertThat(result).isEqualTo(answer);
    }
}
