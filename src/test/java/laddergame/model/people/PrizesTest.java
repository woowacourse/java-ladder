package laddergame.model.people;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrizesTest {
    private People people;

    @BeforeEach
    void createPeople() {
        people = new People(List.of("tori", "pobi", "9mak"));
    }

    @Test
    @DisplayName("문자열 분리 테스트")
    void Should_Split_When_Input() {
        assertDoesNotThrow(() -> Prizes.from(List.of("10000", "1000", "30000"), people));
    }

    @Nested
    @DisplayName("실행 결과 개수 테스트")
    class Size {
        @Test
        @DisplayName("참여자의 수와 실행 결과 수 같을 때 성공")
        void Success() {
            assertDoesNotThrow(() -> Prizes.from(List.of("10000", "1000", "30000"), people));
        }

        @Test
        @DisplayName("참여자의 수와 실행 결과 수가 다를 때 예외 발생")
        void Fail() {
            assertThatThrownBy(() -> Prizes.from(List.of("1000"), people));
        }
    }
}
