package domain;

import exception.InvalidLadderHeightException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;

class LadderTest {

    @DisplayName("사다리의 높이가 조건에 맞을 경우 객체를 생성한다.")
    @Test
    void ladderSuccess() {
        try {
            Ladder ladder = new Ladder(10);
            int height = ladder.getHeight();
            Assertions.assertThat(height).isEqualTo(10);
        } catch (IllegalArgumentException exception) {
            Assertions.fail("높이가 조건에 맞을 경우 객체를 생성해야 합니다.");
        }
    }

    @DisplayName("사다리의 높이가 10을 넘을 경우 오류를 던진다.")
    @Test
    void heightOver10() {
        Assertions.assertThatThrownBy(() -> new Ladder(11))
            .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("사다리의 높이가 1보다 작을 경우 오류를 던진다.")
    @Test
    void heightLessThan1() {
        Assertions.assertThatThrownBy(() -> new Ladder(0))
            .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("연결하면 안 되는 곳이 없을 경우 모두 연결된 상태를 가진다.")
    @Test
    void makeStatus() {
        List<Integer> avoid = List.of();
        Ladder ladder = new Ladder(3);
        BooleanGenerator booleanGenerator = () -> true;
        ladder.generateStatus(avoid, booleanGenerator);
        Assertions.assertThat(ladder.getStatus()).isEqualTo(new boolean[]{true, true, true});
    }

    @DisplayName("연결하면 안 되는 곳 제외 모두 연결된 상태를 가진다.")
    @Test
    void makeStatusWithAvoidExist() {
        List<Integer> avoid = List.of(1);
        Ladder ladder = new Ladder(3);
        BooleanGenerator booleanGenerator = () -> true;
        ladder.generateStatus(avoid, booleanGenerator);
        Assertions.assertThat(ladder.getStatus()).isEqualTo(new boolean[]{true, false, true});
    }

    @DisplayName("연결되어 있는 곳의 인덱스를 리스트로 반환한다.(연결된 곳이 없을 경우)")
    @Test
    void getConnectedIndexNoConnected() {
        Ladder ladder = new Ladder(3);
        BooleanGenerator booleanGenerator = () -> false;
        ladder.generateStatus(List.of(), booleanGenerator);
        List<Integer> connectedIndex = ladder.getConnectedIndex();
        Assertions.assertThat(connectedIndex).isEmpty();
    }

    @DisplayName("연결되어 있는 곳의 인덱스를 리스트로 반환한다. (연결된 곳이 있을 경우)")
    @Test
    void getConnectedIndexConnected() {
        Ladder ladder = new Ladder(3);
        BooleanGenerator booleanGenerator = () -> true;
        ladder.generateStatus(List.of(), booleanGenerator);
        List<Integer> connectedIndex = ladder.getConnectedIndex();
        Assertions.assertThat(connectedIndex).containsExactly(0, 1, 2);
    }
}
