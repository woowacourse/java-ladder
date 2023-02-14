package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@DisplayName("이름들은 ")
class NamesTest {
    @Nested
    @DisplayName("중복된 사람이 ")
    class DuplicatedCase {
        @Test
        @DisplayName("없을 경우 정상적으로 객체 생성")
        void whenNoDuplicatedNames() {
            assertThatCode(() -> new Names(List.of("pobi", "crong")))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("있을 경우 익셉션 발생")
        void whenDuplicatedNames() {
            assertThatThrownBy(() -> new Names(List.of("pobi", "pobi")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 사람은 참여할 수 없습니다.");
        }
    }
}