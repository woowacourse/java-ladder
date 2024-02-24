package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import ladder.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("이전 포지션에 발판이 존재하면 발판을 생성하지 않는다.")
    void hasRungDuplicatedTest() {
        List<Boolean> mockStatus = new ArrayList<>(List.of(true, true, true));
        Line line = new Line(new MockBooleanGenerator(mockStatus), 4);

        List<Boolean> rungBuildStatus = line.getRungs().buildStatusList();
        assertThat(rungBuildStatus).containsExactly(true, false, true);
    }

    @Test
    @DisplayName("random 상태가 false면 발판을 생성하지 않는다.")
    void randomStatusFalseLineTest() {
        List<Boolean> mockStatus = new ArrayList<>(List.of(false, false, false));
        Line line = new Line(new MockBooleanGenerator(mockStatus), 4);

        List<Boolean> rungBuildStatus = line.getRungs().buildStatusList();
        assertThat(rungBuildStatus).containsExactly(false, false, false);
    }
}
