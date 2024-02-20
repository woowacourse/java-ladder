import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineStateTest {

    @DisplayName("LineState는 3가지 상태를 가지고 있는 enum이다.")
    @Test
    void createParticipants() {
        String start = "start";
        String end = "end";
        String nothing = "nothing";

        List<String> result = Arrays.stream(LineState.values())
                .map(LineState::getState)
                .toList();

        assertThat(result)
                .containsExactlyInAnyOrder(start, end, nothing);
    }
}