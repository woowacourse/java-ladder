package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.MockRungGenerator;
import ladder.domain.Prizes;
import ladder.domain.participant.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Rung> rungs = new ArrayList<>(List.of(
                Rung.EXIST, Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST));

        ladder = new Ladder(3, 5, new MockRungGenerator(rungs));
    }

    @Test
    @DisplayName("매개변수 height와 생성되는 사다리와 사다리의 높이는 일치해야 한다.")
    void ladderHeightTest() {
        int ladderHeight = ladder.getFloors().size();

        assertThat(ladderHeight).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("생성되는 사다리의 가로 공간은 사람 수 보다 1적어야 한다.")
    void ladderHorizontalLengthTest(int heightPosition) {
        Floor floor = ladder.getFloors().get(heightPosition);
        int maxRungsCount = floor.getRungs().size();

        assertThat(maxRungsCount).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자들의 사다리 결과에 상품 순서를 정렬한다.")
    void getLadderGameResultTest() {
        Participants participants = new Participants(new ArrayList<>(List.of("aru", "pola", "sang", "horgi", "jazz")));
        Prizes prizes = new Prizes(new ArrayList<>(List.of("3000", "꽝", "5000", "꽝", "꽝꽝")), 5);

        Prizes sortedPrizes = ladder.getSortedPrizesResult(participants, prizes);

        Prizes expectedPrizes = new Prizes(new ArrayList<>(List.of("꽝", "3000", "꽝", "5000", "꽝꽝")), 5);
        assertThat(sortedPrizes.getPrizes()).isEqualTo(expectedPrizes.getPrizes());
    }

}
