package laddergame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
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
        final List<Boolean> line = List.of(true, false, true);

        // when
        Ladder ladder = Ladder.create(3, height, () -> true);

        // then
        assertThat(ladder).extracting("lines")
                .isEqualTo(createLadder(line, value));
    }

    public static List<List<Boolean>> createLadder(final List<Boolean> line, final int size) {
        List<List<Boolean>> ladder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladder.add(line);
        }
        return ladder;
    }
}
