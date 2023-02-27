package ladder.domain;

import static ladder.domain.LadderGameResult.INVALID_PLAYER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameResultTest {

    @Test
    void 사다리게임에_참가하지_않은_사람의_게임_결과를_조회한다면_예외를_던진다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                Player.of("name", 0), Item.of("1000", 0)
        ));

        assertThatThrownBy(() -> ladderGameResult.get("whois"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PLAYER_MESSAGE);
    }

    @Test
    void 한_사람에_대한_게임_결과를_반환한다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                Player.of("name", 0), Item.of("1000", 0)
        ));

        final Map<String, String> result = ladderGameResult.get("name");

        assertThat(result).containsEntry("name", "1000");
    }

    @Test
    void 모든_사람에_대한_게임_결과를_반환한다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                Player.of("name", 0), Item.of("0", 0),
                Player.of("name2", 1), Item.of("1000", 1)
        ));

        final Map<String, String> result = ladderGameResult.get("all");

        assertThat(result).contains(entry("name", "0"), entry("name2", "1000"));
    }

    @ParameterizedTest(name = "입력한 참가자가 존재하거나 예약어인 경우 예외를 던지지 않는다. 입력값: {0}")
    @ValueSource(strings = {"name", "all"})
    void 입력한_참가자가_존재하거나_예약어인_경우_예외를_던지지_않는다(final String name) {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                Player.of("name", 0), Item.of("0", 0),
                Player.of("name2", 1), Item.of("1000", 1)
        ));

        assertThatNoException().isThrownBy(() -> ladderGameResult.validatePlayerName(name));
    }

    @Test
    void 입력한_참가자가_존재하지_않는다면_예외를_던진다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                Player.of("name", 0), Item.of("0", 0),
                Player.of("name2", 1), Item.of("1000", 1)
        ));

        assertThatThrownBy(() -> ladderGameResult.validatePlayerName("noName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PLAYER_MESSAGE);
    }
}
