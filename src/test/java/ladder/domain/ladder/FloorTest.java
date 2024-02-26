package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FloorTest {

    @Test
    @DisplayName("이전 포지션에 발판이 존재하면 발판을 생성하지 않는다.")
    void previousPositionRungExistTest() {
        List<Rung> mockedRungs = new ArrayList<>(List.of(Rung.EXIST, Rung.EXIST, Rung.EXIST, Rung.EXIST));
        Floor floor = new Floor(new MockRungGenerator(mockedRungs), 5);

        List<Boolean> rungBuiltStatus = floor.getRungs().buildStatusList();
        assertThat(rungBuiltStatus).containsExactly(true, false, true, false);
    }

    @Test
    @DisplayName("random 상태가 false면 발판을 생성하지 않는다.")
    void randomStatusFalseRungTest() {
        List<Rung> mockedRungs = new ArrayList<>(List.of(Rung.NOT_EXIST, Rung.NOT_EXIST, Rung.NOT_EXIST));
        Floor floor = new Floor(new MockRungGenerator(mockedRungs), 4);

        List<Boolean> rungBuiltStatus = floor.getRungs().buildStatusList();
        assertThat(rungBuiltStatus).containsExactly(false, false, false);
    }

    @Test
    @DisplayName("발판이 존재하는 위치들을 반환한다.")
    void getExistRungPosition() {
        List<Rung> mockedRungs = new ArrayList<>(List.of(Rung.EXIST, Rung.NOT_EXIST, Rung.EXIST, Rung.NOT_EXIST));
        Floor floor = new Floor(new MockRungGenerator(mockedRungs), 5);

        List<Integer> existRungPositions = floor.getExistRungPositions();

        assertThat(existRungPositions).containsExactly(0, 2);
    }
}
