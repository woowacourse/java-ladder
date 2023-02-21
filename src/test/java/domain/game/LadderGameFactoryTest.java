package domain.game;

import domain.ladder.LadderFactory;
import domain.ladder.Scaffold;
import domain.ladder.ScaffoldGenerator;
import domain.value.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("LadderGameFactory 는")
class LadderGameFactoryTest {

    private final Height height = Height.of(5);
    private final Names names = new Names(List.of(
            new Name("말랑"), new Name("바다"), new Name("최고"))
    );
    private final WinningEntries winningEntries = new WinningEntries(List.of(
            new WinningEntry("꽝"), new WinningEntry("🌊"), new WinningEntry("산")),
            names
    );

    private final ScaffoldGenerator generator = () -> Scaffold.EXIST;
    private final LadderFactory ladderFactory = new LadderFactory(generator);
    private final LadderGameFactory ladderGameFactory = new LadderGameFactory(ladderFactory);

    @Test
    void 이름_당첨항목_사다리의_높이를_통해_사다리_게임을_생성한다() {
        // when
        LadderGame game = ladderGameFactory.createGame(names, winningEntries, height);

        // then
        Assertions.assertAll(
                () -> assertThat(game.ladder().getHeight()).isEqualTo(height),
                () -> assertThat(game.names()).isEqualTo(names),
                () -> assertThat(game.winningEntries()).isEqualTo(winningEntries)
        );
    }
}