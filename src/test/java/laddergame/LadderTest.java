package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.LineSize;
import laddergame.domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void createLadder(int value) {
        // given
        final LadderHeight height = new LadderHeight(value);
        final LineSize lineSize = new LineSize(new Names(List.of("pobi", "zeze", "crong", "jk")));

        // when
        Ladder ladder = Ladder.create(lineSize, height, () -> true);

        // then
        final List<Boolean> expected = List.of(true, false, true);

        assertThat(ladder.getLinesState())
                .isEqualTo(createLadder(expected, value));
    }

    public static List<List<Boolean>> createLadder(final List<Boolean> line, final int size) {
        List<List<Boolean>> ladder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladder.add(line);
        }
        return ladder;
    }
}
