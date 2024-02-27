package domain;

import domain.line.NonContinuousLineGenerator;
import domain.name.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("게임의 결과를 만든다")
    @RepeatedTest(500)
    void fromTest() {
        Names names = Names.from(List.of("a", "b", "c", "d"));
        UndecidedResults undecidedResults = new UndecidedResults(names, List.of("1", "2", "3", "4"));
        Ladder ladder = Ladder.createFrom(new NonContinuousLineGenerator(), names.getNameCount(), new Height(5));

        LadderResult ladderResult = LadderResult.of(ladder, names, undecidedResults);
        assertThat(ladderResult.getResult()).hasSize(4);
    }
}
