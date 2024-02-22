package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("입력받은 높이만큼 사다리를 생성한다.")
    void createLadder() {
        // given
        int value = 5;
        Height height = new Height(value);
        People people = new People("pobi,honux,crong,jk");

        // when
        Ladder ladder = new Ladder(people, height);

        // then
        assertThat(ladder.getLadder()).hasSize(value);
    }
}