package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NameTest {

    @Test
    @DisplayName("Name 객체 생성 성공 테스트")
    void createNameTest() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            new Name("ocean");
        });
    }

    @Test
    @DisplayName("이름 값 길이 제한으로 인한 Player 객체 생성 실패 테스트")
    void limitPlayerNameLengthTest() {
        //When
        Throwable result = catchThrowable(() -> {
            new Name("woowacourse");
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", " ", "@#$@", "abs@#"})
    @DisplayName("사람 이름은 문자로만 이루어져 있는지 확인하는 기능 테스트")
    void validateNameHasOnlyCharacters(String inputName) {
        //When
        Throwable result = catchThrowable(() -> {
            new Name(inputName);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Disabled("단순 getter 메서드는 테스트하지 않는다.")
    void getName() {
    }

    @Test
    @DisplayName("사람 이름 간 비교하는 기능 테스트")
    void compareNameTest() {
        //Given
        Name name = new Name("pobi");

        //Then
        assertThat(name).isEqualTo(new Name("pobi"));
        assertThat(name).isNotEqualTo(new Name("neo"));
    }
}
