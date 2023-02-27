package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import generator.RandomLineGenerator;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("라인 생성 확인")
    void makeLine() {
        LineMaker lineMaker = new LineMaker(new RandomLineGenerator());
        int numberOfLine = 3;

        assertDoesNotThrow(
                () -> new Line(lineMaker.makeLineStatus(numberOfLine))
        );
    }

    @Test
    @DisplayName("빈 리스트로 Line 생성 시 예외 발생")
    void validateEmptyList() {
        assertThatThrownBy(() -> new Line(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("[ERROR] 빈 리스트로 Line을 생성할 수 없습니다.");
    }
}
