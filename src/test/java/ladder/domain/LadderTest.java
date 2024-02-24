package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.dto.LadderResponseDto;
import ladder.domain.dto.LineResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private Height height;

    @BeforeEach
    void setUp() {
        height = new Height("3");
    }

    @Test
    @DisplayName("매개변수 height와 생성되는 사다리와 사다리의 높이는 일치해야 한다.")
    void ladderHeightTest() {
        Ladder ladder = new Ladder(height, 5, () -> true);
        LadderResponseDto resultLadders = ladder.getResultLadders();
        int ladderHeight = resultLadders.ladderResult().size();

        assertThat(ladderHeight).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("생성되는 사다리의 가로 공간은 사람 수 보다 1적어야 한다.")
    void ladderHorizontalLengthTest(int heightPosition) {
        Ladder ladder = new Ladder(height, 5, () -> true);
        LadderResponseDto resultLadders = ladder.getResultLadders();
        LineResponseDto lineResponseDto = resultLadders.ladderResult().get(heightPosition);
        int maxRungsCount = lineResponseDto.buildStatusList().size();

        assertThat(maxRungsCount).isEqualTo(4);
    }
}
