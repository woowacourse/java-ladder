package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesCreatorTest {
    @Test
    @DisplayName("참여자 이름들 생성자가 생성될 때 예외가 발생하지 않음")
    void testCreateNameCreator() {
        Assertions.assertThatCode(NamesCreator::new).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있으면 예외 발생")
    void validateSeparator(String names) {
        var nameCreator = new NamesCreator();
        Assertions.assertThatThrownBy(() -> nameCreator.create(names))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_SEPARATOR_POSITION.getMessage());
    }
}