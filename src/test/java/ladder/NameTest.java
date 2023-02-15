package ladder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("알맞은 길이의 이름을 넣으면 name을 생성한다")
    void shouldBetween1and5WhenNameCreate() {
        // given
        // when
        // then
        assertDoesNotThrow(()-> new Name("abcde"));
    }
}
