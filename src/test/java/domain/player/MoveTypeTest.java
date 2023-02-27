package domain.player;

import domain.ladder.Line;
import domain.booleangenerator.TestBooleanGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveTypeTest {

    @DisplayName("플레이어와 line의 연결 구조를 파악해서 플레이어가 움직일 방향을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"kong:1:LEFT", "kong:0:RIGHT", "kong:2:STAY"}, delimiter = ':')
    void moveTypeTest1(String name, int position, MoveType expected) {
        Player player = new Player(name, position);
        Line line = Line.of(4, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        MoveType moveType = MoveType.getMoveTypeByPosition(player, line);

        assertThat(moveType).isEqualTo(expected);
    }

    @DisplayName("플레이어의 위치 정보가 사다리의 범위를 벗어난 경우 움직일 방향을 구할 때 사다리 범위 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"kong:4:4", "kong:2:1"}, delimiter = ':')
    void moveTypeTest2(String name, int position, int personCount) {
        Player player = new Player(name, position);
        Line line = Line.of(personCount, new TestBooleanGenerator(Lists.newArrayList(true, false, false)));
        assertThatThrownBy(() -> MoveType.getMoveTypeByPosition(player, line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 가로줄의 번호는 0부터 플레이어 수 - 1까지의 범위를 갖는 정수로 입력해주세요.");
    }
}
