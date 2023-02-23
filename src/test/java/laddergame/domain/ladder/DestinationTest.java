package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DestinationTest {

    @Test
    @DisplayName("전달받은 위치에 해당하는 결과를 반환한다.")
    void should_ReturnValue_By_Index() {
        Destination destination = new Destination(List.of("꽝", "꽝", "10000"));

        assertThat(destination.get(0)).isEqualTo("꽝");
    }

    @Test
    @DisplayName("개수를 넘어서는 위치를 전달받은 경우 예외를 던진다.")
    void should_ThrowException_When_GivenIndex_OutOfBounds() {
        Destination destination = new Destination(List.of("꽝", "꽝", "10000"));

        assertThatThrownBy(() -> destination.get(Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주어진 위치가 종착지 정보의 개수보다 큽니다.");
    }
}
