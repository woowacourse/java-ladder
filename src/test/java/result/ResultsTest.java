package result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest
    @ValueSource(strings = {"one", "one,two,three,four,five,six,seven,eight,nine,ten,elevn"})
    @DisplayName("결과 개수가 범위를 벗어나면 예외를 발생한다.")
    void invalidSizeTest(String names) {
        // given
        List<String> resultNames = List.of(names.split(","));
        // when, then
        assertThatThrownBy(() -> new Results(resultNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과의 개수를 올바르게 반환한다.")
    void resultsSizeTest() {
        // given
        Results results = new Results(List.of("꽝", "10000", "바나나우유"));
        // when, then
        assertThat(results.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("인덱스에 해당하는 결과명을 올바르게 반환한다.")
    void findByIndexTest() {
        // given
        Results results = new Results(List.of("꽝", "10000", "바나나우유"));
        // when, then
        assertThat(results.getNameByIndex(0)).isEqualTo("꽝");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("인덱스가 범위를 벗어나면 예외를 발생한다.")
    void findByIndexOutOfBoundTest(int index) {
        // given
        Results results = new Results(List.of("꽝", "10000", "바나나우유"));
        // when, then
        assertThatThrownBy(() -> results.getNameByIndex(index))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
