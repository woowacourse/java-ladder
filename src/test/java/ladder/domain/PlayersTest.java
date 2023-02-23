package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("플레이어가 1명 이하면 예외 던지기")
    public void size_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어 이름이 중복이면 예외 던지기")
    public void 이름_중복_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀", "에밀")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 중복이 존재합니다");
    }

    @Test
    @DisplayName("플레이어수를 반환한다")
    public void getPlayerSize() {
        assertThat(Players.from(List.of("에밀", "홍고"))
                          .getCount())
                .isEqualTo(2);
    }

    @Test
    void should_플레이어의이름과상품을반환_when_사다리가주어졌을때() {
        // given
        Players players = Players.from(List.of("첫째", "둘째", "셋째", "넷째", "다섯째"));
        Ladder ladder = new Ladder(LadderTest.generateRowList());
        List<String> prizes = List.of(
                "2",
                "0",
                "1",
                "3",
                "4"
        );
        Map<String, String> expected = new LinkedHashMap<>(Map.of(
                "첫째", "2",
                "둘째", "0",
                "셋째", "1",
                "넷째", "3",
                "다섯째", "4"
        ));

        // when
        Map<String, String> gameResult = players.climbDownLadderAndWinPrize(ladder, prizes);

        //then
        assertThat(gameResult).isEqualTo(expected);
    }
}
