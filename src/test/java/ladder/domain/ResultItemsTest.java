package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultItemsTest {

    @DisplayName("가변 인자로 결과 항목들을 생성한다.")
    @Test
    void createResultItemsWithVarargs() {
        // when
        ResultItems resultItems = new ResultItems(4, "꽝", "5000", "꽝", "3000");

        // then
        assertThat(resultItems.getResultItems()).extracting(ResultItem::getValue)
                .containsExactly("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("결과 항목 수가 참여자 수와 같지 않으면 예외가 발생한다.")
    @Test
    void validateSize() {
        // when & then
        assertThatThrownBy(() -> new ResultItems(2, "꽝", "5000", "꽝", "3000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 항목들을 생성한다.")
    @Test
    void createResultItems() {
        // given
        List<String> rawResultItems = List.of("꽝", "5000", "꽝", "3000");

        // when
        ResultItems resultItems = new ResultItems(4, rawResultItems);

        // then
        assertThat(resultItems.getResultItems()).extracting(ResultItem::getValue)
                .containsExactly("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("인덱스의 결과 항목을 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 꽝", "1, 5000", "2, 꽝", "3, 3000"})
    void get(int index, String actual) {
        // given
        ResultItems resultItems = new ResultItems(4, "꽝", "5000", "꽝", "3000");

        // when
        ResultItem resultItem = resultItems.get(new Index(index));

        // then
        assertThat(resultItem.getValue()).isEqualTo(actual);
    }
}
