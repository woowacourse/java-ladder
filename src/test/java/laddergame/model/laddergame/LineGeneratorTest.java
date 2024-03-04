package laddergame.model.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laddergame.exception.BaseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineGeneratorTest {
    @DisplayName("선분연결결정들로 Line 객체를 반환한다.")
    @Test
    void generateLineTest() {
        //given
        List<LineConnectionDecision> given = List.of(
                new LineConnectionDecision(true),
                new LineConnectionDecision(false),
                new LineConnectionDecision(true),
                new LineConnectionDecision(false)
        );
        LineGenerator lineGenerator = new LineGenerator(given);
        Line line = lineGenerator.generate();
        //when //then
        assertThat(line.getLineStates()).hasSize(given.size());
    }

    @DisplayName("선분연결결정들 크기가 2보다 작으면 예외가 발생한다.")
    @Test
    void validateBooleansSize() {
        List<LineConnectionDecision> given = List.of(
                new LineConnectionDecision(true)
        );
        //when //then
        assertThatThrownBy(() -> new LineGenerator(given)).isInstanceOf(BaseException.class);
    }
}
