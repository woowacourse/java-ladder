package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름은 1~5 글자를 넘지않는다.")
    void makeNameLengthFailure() {
        String wrongName = "abcdef";
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름은 1~5 글자이다.")
    void makeNameSuccess() {
        String rightName = "name";
        assertThatNoException().isThrownBy(() -> new Name(rightName));
    }
}
