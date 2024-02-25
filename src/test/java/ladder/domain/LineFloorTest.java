package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineFloorTest {

    @DisplayName("라인 층 번호를 입력하면 인스턴스를 생성한다.")
    @Test
    void 라인_층_번호_인스턴스_생성() {
        // Given
        final int inputLineFloor = 5;

        // When
        LineFloor lineFloor = new LineFloor(inputLineFloor);

        // Then
        assertThat(lineFloor).isNotNull();
    }

    @DisplayName("유효하지 않은 층 번호가 입력되면 예외를 발생시킨다.")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    void 유효하지_않은_층_번호_예외_발생(final int inputLineFloor) {
        // When & Then
        assertThatThrownBy(() -> new LineFloor(inputLineFloor))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 라인 층 번호입니다.");
    }
}
