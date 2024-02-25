package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineFloorTest {

    @DisplayName("라인 층 번호를 입력하면 인스턴스를 생성한다.")
    @Test
    void 라인_층_번호_인스턴스_생성() {
        // Given
        final int inputLineFloorNumber = 5;

        // When
        LineFloor lineFloor = new LineFloor(inputLineFloorNumber);

        // Then
        assertThat(lineFloor).isNotNull();
    }
}
