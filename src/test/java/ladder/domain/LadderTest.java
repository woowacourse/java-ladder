package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.MockRungGenerator;
import ladder.domain.dto.FloorResponseDto;
import ladder.domain.dto.LadderResponseDto;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    private List<Rung> rungs;

    @BeforeEach
    void setUp() {
        rungs = new ArrayList<>(List.of(
                Rung.EXIST, Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST, Rung.EXIST,
                Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST));
    }

    @Test
    @DisplayName("매개변수 height와 생성되는 사다리와 사다리의 높이는 일치해야 한다.")
    void ladderHeightTest() {
        Ladder ladder = new Ladder(3, 5, new MockRungGenerator(rungs));
        LadderResponseDto resultLadders = ladder.getResultLadders();
        int ladderHeight = resultLadders.ladderResult().size();

        assertThat(ladderHeight).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("생성되는 사다리의 가로 공간은 사람 수 보다 1적어야 한다.")
    void ladderHorizontalLengthTest(int heightPosition) {
        Ladder ladder = new Ladder(3, 5, new MockRungGenerator(rungs));
        LadderResponseDto resultLadders = ladder.getResultLadders();
        FloorResponseDto floorResponseDto = resultLadders.ladderResult().get(heightPosition);
        int maxRungsCount = floorResponseDto.buildStatusList().size();

        assertThat(maxRungsCount).isEqualTo(4);
    }

    @Test
    @DisplayName("참여자들의 사다리 타기 결과를 반환한다.")
    void getLadderGameResultTest() {
        Participants participants = new Participants(new ArrayList<>(List.of("aru", "pola", "sang", "horgi", "jazz")));
        Ladder ladder = new Ladder(3, participants.getCount(), new MockRungGenerator(rungs));

        List<Name> participantsResult = ladder.getLadderGameResult(participants);

        assertThat(participantsResult)
                .containsExactly(new Name("pola"), new Name("sang"), new Name("horgi"), new Name("aru"),
                        new Name("jazz"));
    }

}
