package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Name 은")
public class NameTest {

    @ParameterizedTest(name = "다섯 글자가 최대이다")
    @ValueSource(strings = {"일", "두울", "세글자", "네에글자", "다섯글자끝"})
    void Name_은_5_글자가_최대이다(final String name) {
        assertDoesNotThrow(() -> new Name(name));
    }

    @ParameterizedTest(name = "공백 혹은 다섯글자를 초과시 에러를 발생시킨다")
    @ValueSource(strings = {"", "여섯글자에요"})
    void Name_은_다섯글자_초과_혹은_공백일_수_없다(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "생성 시 파라미터로 받은 이름을 값으로 가진다")
    @ValueSource(strings = {"일", "두울", "세글자", "네에글자", "다섯글자끝"})
    void 생성_시_파라미터로_받은_이름을_값으로_가진다(final String input) {
        Name name = new Name(input);
        Assertions.assertThat(name.getValue()).isEqualTo(input);
    }

    @ParameterizedTest(name = "생성 시 파라미터로 받은 이름을 값으로 가진다")
    @ValueSource(strings = {"일", "두울", "세글자", "네에글자", "다섯글자끝"})
    void 글자_수를_구할_수_있다(final String input) {
        Name name = new Name(input);
        Assertions.assertThat(name.length()).isEqualTo(input.length());
    }
}
