package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    @Test
    void 사다리게임은_참여자들의_이름과_사다리의_높이를_받는다() {
        final LadderGame ladderGame = new LadderGame(() -> true, List.of("name1", "name2"), 2);

        Assertions.assertAll(
                () -> assertThat(ladderGame.getPlayers()).containsExactly("name1", "name2"),
                () -> assertThat(ladderGame.getLadder()).containsExactly(
                        new Line(List.of(LineStatus.GO)),
                        new Line(List.of(LineStatus.GO))
                )
        );
    }

}
