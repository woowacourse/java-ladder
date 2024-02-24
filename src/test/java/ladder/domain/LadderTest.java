package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이만큼 사다리의 라인을 생성한다.")
    void createLadder() {
        // given
        Height height = new Height("5");
        People people = new People("pobi,honux,crong,jk");

        // when
        Ladder ladder = new Ladder(people, height);

        // then
        assertThat(ladder.getLadder()).hasSize(5);
    }
}
