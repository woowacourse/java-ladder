package domain.vo;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class NameTest {

    @ParameterizedTest(name = "이름의 길이는 1 ~ 5 사이여야 합니다.")
    @ValueSource(strings = {"", "abcdef"})
    void makeHeightFailure(String provided) {
        AssertionsForClassTypes.assertThatThrownBy(() -> new Name(provided))
                .hasMessage("이름 길이는 1 ~ 5 사이여야 합니다.");
    }

    @Test
    @DisplayName("이름은 1~5 글자이다.")
    void makeNameSuccess() {
        String rightName = "name";
        assertThatNoException().isThrownBy(() -> new Name(rightName));
    }
}
