package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderGameResultTest {

    @Test
    void 사다리게임에_참가하지_않은_사람을_입력하면_예외를_던진다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                new Player("name"), new Item("1000")
        ));

        assertThatThrownBy(() -> ladderGameResult.get("whois"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임에 참가한 사람의 이름을 입력해야합니다.");
    }

    @Test
    void 한_사람에_대한_게임_결과를_반환한다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                new Player("name"), new Item("1000")
        ));

        final Map<String, String> result = ladderGameResult.get("name");

        assertThat(result).containsExactly(entry("name", "1000"));
    }

    @Test
    void 모든_사람에_대한_게임_결과를_반환한다() {
        final LadderGameResult ladderGameResult = new LadderGameResult(Map.of(
                new Player("name"), new Item("0"),
                new Player("name2"), new Item("1000")
        ));

        final Map<String, String> result = ladderGameResult.get("all");

        assertThat(result).contains(entry("name", "0"), entry("name2", "1000"));
    }

}
