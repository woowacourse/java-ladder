package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.MockRungGenerator;
import ladder.domain.Prizes;
import ladder.domain.dto.FloorResponseDto;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.participant.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private List<Rung> rungs;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        rungs = new ArrayList<>(List.of(
                Rung.EXIST, Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST));

        ladder = new Ladder(3, 5, new MockRungGenerator(rungs));
    }

    @Test
    @DisplayName("매개변수 height와 생성되는 사다리와 사다리의 높이는 일치해야 한다.")
    void ladderHeightTest() {
        LadderResponseDto resultLadders = ladder.getLadderResult();
        int ladderHeight = resultLadders.ladderResult().size();

        assertThat(ladderHeight).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("생성되는 사다리의 가로 공간은 사람 수 보다 1적어야 한다.")
    void ladderHorizontalLengthTest(int heightPosition) {
        LadderResponseDto resultLadder = ladder.getLadderResult();
        FloorResponseDto floorResponseDto = resultLadder.ladderResult().get(heightPosition);
        int maxRungsCount = floorResponseDto.buildStatusList().size();

        assertThat(maxRungsCount).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자들의 사다리 결과에 상품 순서를 정렬한다.")
    void getLadderGameResultTest() {
        Participants participants = new Participants(new ArrayList<>(List.of("aru", "pola", "sang", "horgi", "jazz")));
        Prizes prizes = new Prizes(new ArrayList<>(List.of("3000", "꽝", "5000", "꽝", "꽝꽝")), 5);

        Prizes sortedPrizes = ladder.getSortedPrizes(participants, prizes);

        assertThat(sortedPrizes.getNames()).containsExactly("꽝", "3000", "꽝", "5000", "꽝꽝");
    }

}
