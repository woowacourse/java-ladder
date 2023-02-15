package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class LadderTest {
    @Test
    @DisplayName("사다리 높이가 2 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        List<Raw> ladder = new ArrayList<>();
        Raw raw = new Raw(4);
        ladder.add(raw);
        Assertions.assertThatThrownBy(() -> new Ladder(ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 높이가 2 이상이면 통과하는 테스트")
    void validHeightTest() {
        List<Raw> ladder = new ArrayList<>();
        Raw raw1 = new Raw(4);
        Raw raw2 = new Raw(4);
        ladder.add(raw1);
        ladder.add(raw2);
        assertThatCode(() -> new Ladder(ladder)).doesNotThrowAnyException();
    }
}