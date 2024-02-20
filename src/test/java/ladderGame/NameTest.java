package ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("문자열을 인자로 넘겨서 Name 객체를 생성할 수 있다.")
    void createName() {
        assertThatCode(() -> new Name("이름"));
    }
}