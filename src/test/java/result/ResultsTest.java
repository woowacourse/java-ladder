package result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.Players;

class ResultsTest {

    @Test
    @DisplayName("결과 문자열들로 일급 컬렉션을 올바르게 생성한다.")
    void validCreationTest() {
        assertDoesNotThrow(() -> new Results(List.of("꽝", "10000", "바나나우유")));
    }

    @Test
    @DisplayName("결과들의 이름을 올바르게 가져온다.")
    void getNamesTest() {
        // given
        Results results = new Results(List.of("꽝", "10000", "바나나우유"));
        // when
        List<String> actual = results.getNames();
        // then
        assertThat(actual).containsExactly("꽝", "10000", "바나나우유");
    }
}
