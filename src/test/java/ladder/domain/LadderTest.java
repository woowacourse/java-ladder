package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    
    private List<Name> names;

    @BeforeEach
    void setUp() {
        Name pobi = new Name("pobi");
        Name honux = new Name("honux");
        Name crong = new Name("crong");
        Name jk = new Name("jk");
        names = new ArrayList<>(List.of(pobi, honux, crong, jk));
    }

    @Test
    @DisplayName("입력받은 높이만큼 사다리를 생성한다.")
    void createLadder() {
        // given
        Height height = new Height(5);
        People people = new People(names);

        // when
        Ladder ladder = new Ladder(people, height);

        // then
        assertThat(ladder.getLadder()).hasSize(5);
    }
}
