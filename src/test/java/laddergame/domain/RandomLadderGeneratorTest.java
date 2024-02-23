package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLadderGeneratorTest {

    @DisplayName("랜덤으로 사다리를 생성할 수 있다.")
    @Test
    void generate() {
        // given
        final LineSize lineSize = new LineSize(new Names(List.of("pobi", "honux", "crong", "jk")));
        final LadderHeight ladderHeight = new LadderHeight(5);

        final LadderGenerator ladderGenerator = new RandomLadderGenerator();

        // when & then
        assertThatCode(() -> ladderGenerator.generate(lineSize, ladderHeight))
                .doesNotThrowAnyException();
    }

}
