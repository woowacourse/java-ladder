package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineGeneratorTest {
    @DisplayName("불린 리스트로 Line 객체를 반환한다.")
    @Test
    void generateLineTest() {
        List<Boolean> given = List.of(true, false, true, false);
        LineGenerator lineGenerator = new LineGenerator(given);
        Line line = lineGenerator.generate();

        assertThat(line.getLineStates()).hasSize(given.size());
    }

    @DisplayName("boolean 리스트 크기가 2보다 작으면 예외가 발생한다.")
    @Test
    void validateBooleansSize() {
        assertThatThrownBy(() -> new LineGenerator(List.of(true)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
