package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import util.TestScaffoldGenerator;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Ladder 는")
public class LadderTest {

    ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();

    @Test
    void Height_과_Width_와_ScaffoldGenerator_를_받아_생성된다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);

        assertDoesNotThrow(() -> new Ladder(width, height, scaffoldGenerator));
    }

    @Test
    void 인자로_받은_Height_을_높이로_가진다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);
        final int heightValue = 5;

        // when
        final Ladder ladder = new Ladder(width, height, scaffoldGenerator);

        // then
        assertThat(ladder.getHeight()).isEqualTo(heightValue);
    }

    @Test
    void 인자로_받은_Width_을_너비로_가진다() {
        // given
        final Width width = new Width(5);
        final Height height = new Height(5);
        final int widthValue = 5;

        // when
        final Ladder ladder = new Ladder(width, height, scaffoldGenerator);

        // then
        assertThat(ladder.getWidth()).isEqualTo(widthValue);
    }

    @Test
    void 게임의_결과를_계산할_수_있다() {
        final TestScaffoldGenerator testScaffoldGenerator = new TestScaffoldGenerator(
                List.of(true, false,
                        false, true,
                        true, false));
        final Ladder ladder = new Ladder(new Width(2), new Height(3), testScaffoldGenerator);

        final Name winnerName = new Name("찰리");
        final Prize winnerPrize = new Prize("1등");

        final Names names = new Names(List.of(new Name("바비"), new Name("가비"), winnerName));
        final Prizes prizes = new Prizes(List.of(winnerPrize, new Prize("2등"), new Prize("3등")), names);

        /*
         * 바비  가비  찰리
         *  |----|    |
         *  |    |----|
         *  |----|    |
         * 1등   2등   3등
         *(찰리) (가비) (바비)
         * */

        Map<String, String> result = ladder.calculateResult(names, prizes);

        assertThat(result.get("찰리")).isEqualTo(winnerPrize.getValue());
        assertThat(result.get("가비")).isEqualTo(prizes.getPrizes().get(1).getValue());
        assertThat(result.get("바비")).isEqualTo(prizes.getPrizes().get(2).getValue());
    }
}
