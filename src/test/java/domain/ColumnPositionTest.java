package domain;

import static domain.Direction.LEFT;
import static domain.Direction.RIGHT;
import static domain.Direction.STAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("열 위치 도메인 테스트")
class ColumnPositionTest {
    
    @DisplayName("움직이는 방향을 받아 다음 열 위치를 계산할 수 있다")
    @Test
    void testMovePositionByDirection() {
        ColumnPosition columnPosition = new ColumnPosition(1);

        ColumnPosition leftMoved = columnPosition.nextPosition(LEFT);
        ColumnPosition rightMoved = columnPosition.nextPosition(RIGHT);
        ColumnPosition stayed = columnPosition.nextPosition(STAY);

        assertThat(leftMoved.getColumnPosition()).isEqualTo(0);
        assertThat(rightMoved.getColumnPosition()).isEqualTo(2);
        assertThat(stayed.getColumnPosition()).isEqualTo(1);
    }

    @DisplayName("범위에 벗어나는 위치는 생성에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {-2, -1})
    void testCreatePositionWithInvalidRange(int position) {
        assertThatThrownBy(() -> new ColumnPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 열 위치는 0이상이어야 합니다.");
    }

    @DisplayName("검증 조건을 모두 통과하는 위치는 생성에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void testCreatePositionWithValidRange(int position) {
        assertThatCode(() -> new ColumnPosition(position))
                .doesNotThrowAnyException();
    }
}
