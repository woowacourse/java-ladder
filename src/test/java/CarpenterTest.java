import domain.*;
import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarpenterTest {

    @Test
    @DisplayName("높이와 참가자수, 번호생성기가 주어지면 번호에 따른 랜덤 사다리를 생성한다.")
    void makeLadder() { // TODO: 오류수정
        // given
        final BooleanGenerator trueGenerator = new TrueGenerator();
        final PlayerCount playerCount = PlayerCount.from(3);
        final WoodWorkMachine woodWorkMachine = new WoodWorkMachine(playerCount, trueGenerator);
        final Line line = woodWorkMachine.makeLine();

        // when
        final Carpenter carpenter = new Carpenter(new Height(4), playerCount);

        // then
        assertThat(carpenter.makeLadder()).isEqualTo(new Ladder(List.of(line, line, line, line)));
    }
}
