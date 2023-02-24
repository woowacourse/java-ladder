package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import ladder.util.TestBooleanGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameTest {

    private LadderGame initializeLadderGame(
            final List<String> playerNames,
            final List<Boolean> ladder,
            final int value,
            final List<String> itemNames
    ) {
        final Players players = Players.from(playerNames);
        final BooleanGenerator booleanGenerator = new TestBooleanGenerator(ladder);
        final Height height = new Height(String.valueOf(value));
        final Items items = Items.from(itemNames, players.count());

        return LadderGame.initialize(players, booleanGenerator, height, items);
    }

    @Test
    void 참가자들의_이름을_반환한다() {
        final LadderGame ladderGame = initializeLadderGame(
                List.of("name1", "name2"),
                List.of(true, true),
                2,
                List.of("item1", "item2")
        );

        assertThat(ladderGame.getPlayers()).containsExactly("name1", "name2");
    }

    @Test
    void 생성된_사다리를_반환한다() {
        final LadderGame ladderGame = initializeLadderGame(
                List.of("name1", "name2"),
                List.of(true, true),
                2,
                List.of("item1", "item2")
        );

        assertThat(ladderGame.getLadder())
                .extracting(Line::getLine)
                .containsExactly(
                        List.of(LineStatus.CONNECTED),
                        List.of(LineStatus.CONNECTED)
                );
    }

    @Test
    void 모든_실행결과를_반환한다() {
        final LadderGame ladderGame = initializeLadderGame(
                List.of("name1", "name2"),
                List.of(true, true),
                2,
                List.of("item1", "item2")
        );

        assertThat(ladderGame.getItems()).containsExactly("item1", "item2");
    }

    @Test
    void 모든_참가자에_대한_사다리게임을_진행한다() {
        final LadderGame ladderGame = initializeLadderGame(
                List.of("name1", "name2", "name3"),
                List.of(
                        true, false,
                        false, true
                ),
                2,
                List.of("item1", "item2", "item3")
        );

        LadderGameResult ladderGameResult = ladderGame.play();

        assertThat(ladderGameResult.get("all")).containsExactly(
                entry("name1", "item3"),
                entry("name2", "item1"),
                entry("name3", "item2")
        );
    }
}
