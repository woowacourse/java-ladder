package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {
    @Test
    @DisplayName("사람 이름 중복 검사")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Names(List.of("abcde", "abcde", "abc")))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NAMES_DUPLICATE.getMessage());
    }
}