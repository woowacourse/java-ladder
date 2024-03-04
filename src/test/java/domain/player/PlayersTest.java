package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {
    @Test
    void 중복된_이름이_존재하면_예외가_발생한다() {
        // given
        String duplicateName = "prin";
        String name = "ddang";
        List<String> playerNames = List.of(duplicateName, duplicateName, name);

        // when & then
        assertThatThrownBy(() -> Players.from(playerNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 참가자명이 존재합니다.");
    }

    @Test
    void 중복된_이름이_없으면_예외가_발생하지_않는다() {
        // given
        String uniqueName1 = "prin";
        String uniqueName2 = "ddang";
        String uniqueName3 = "pobi";
        List<String> playerNames = List.of(uniqueName1, uniqueName2, uniqueName3);

        // when & then
        assertDoesNotThrow(() -> Players.from(playerNames));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 51})
    void 참가자_수가_범위를_벗어나면_예외가_발생한다(int playerCount) {
        // given
        List<String> playerNames = IntStream.range(0, playerCount)
                .mapToObj(i -> "프린" + i)
                .toList();

        // when & then
        assertThatThrownBy(() -> Players.from(playerNames))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 2 ~ 50명이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50})
    void 참가자_수가_범위_이내이면_예외가_발생하지_않는다(int playerCount) {
        // given
        List<String> playerNames = IntStream.range(0, playerCount)
                .mapToObj(i -> "프린" + i)
                .toList();

        // when & then
        assertDoesNotThrow(() -> Players.from(playerNames));
    }

    @Test
    void 참가자의_이름_중_가장_긴_이름의_길이를_반환한다() {
        // given
        String maxLengthName = "crong";
        Players players = Players.from(List.of("jk", "pobi", maxLengthName));

        // when
        int result = players.findMaxPlayerNameLength();

        // then
        assertThat(result).isEqualTo(maxLengthName.length());
    }

    @Test
    void 범위를_벗어난_인덱스로_참가자를_찾으면_예외가_발생한다() {
        // given
        Players players = Players.from(List.of("prin", "pobi", "crong"));

        // when & then
        assertThatThrownBy(() -> players.findPlayerByIndex(3))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인덱스로_참가자를_찾는다() {
        // given
        String targetPlayerName = "pobi";
        Players players = Players.from(List.of("prin", "crong", targetPlayerName));

        // when
        Player result = players.findPlayerByIndex(2);

        // then
        assertThat(result.getName()).isEqualTo(targetPlayerName);
    }
}
