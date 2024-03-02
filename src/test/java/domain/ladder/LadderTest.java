package domain.ladder;

import static fixture.PlayersFixture.참가자들;
import static fixture.PrizesFixture.상품들;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.height.Height;
import domain.player.Players;
import domain.prize.Prizes;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import support.FixedBooleanGenerator;
import support.TrueOnlyGenerator;

public class LadderTest {
    @Test
    void 주어진_높이에_맞게_사다리를_생성한다() {
        // given
        Height height = new Height(5);

        // when
        Ladder ladder = Ladder.create(height, 참가자들(3), new TrueOnlyGenerator());

        // then
        assertThat(ladder.getRows()).hasSize(height.getValue());
    }

    @Test
    void 사다리를_탄_후_결과를_반환한다() {
        /*
        프린  땡이  포비  토미  네오
        |-----|     |-----|     |
        |     |-----|     |     |
        |-----|     |     |-----|
        100   꽝   300   500   1000
        */

        // given
        Height height = new Height(3);
        Players players = 참가자들("프린", "땡이", "포비", "토미", "네오");
        Prizes prizes = 상품들("100", "꽝", "300", "500", "1000");
        List<Boolean> connections = List.of(
                true, true, true, true, false,
                false, true, true, false, false,
                true, true, false, true, true
        );

        // when
        Ladder ladder = Ladder.create(height, players, new FixedBooleanGenerator(connections));
        LadderResult ladderResult = ladder.climb(players, prizes);

        // then
        Map<String, String> results = ladderResult.getAllResults();
        assertAll(
                () -> assertThat(results.get("프린")).isEqualTo("300"),
                () -> assertThat(results.get("땡이")).isEqualTo("꽝"),
                () -> assertThat(results.get("포비")).isEqualTo("1000"),
                () -> assertThat(results.get("토미")).isEqualTo("100"),
                () -> assertThat(results.get("네오")).isEqualTo("500")
        );
    }
}
