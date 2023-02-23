package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayersTest {

    @ParameterizedTest(name = "올바른 참가자 수가 아닌 경우 예외를 던진다. 참가자 수 : {0}")
    @ValueSource(ints = {1, 21})
    void 올바른_참가자_수가_아닌_경우_예외를_던진다(final int playerCount) {
        final List<String> names = IntStream.range(0, playerCount)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Players.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 최소 2명, 최대 20명이어야 합니다.");
    }

    @Test
    void 참가자가_두_명_이상인_경우_예외를_던지지_않는다() {
        assertThatNoException().isThrownBy(() -> Players.from(List.of("name1", "name2")));
    }

    @Test
    void 참가자의_이름은_중복되는_경우_예외를_던진다() {
        assertThatThrownBy(() -> Players.from(List.of("name", "name")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 중복되지 않아야 합니다.");
    }

    @Test
    void 참가_인원을_반환한다() {
        final Players players = Players.from(List.of("name1", "name2"));

        assertThat(players.count()).isEqualTo(2);
    }

    @Test
    void 입력받은_위치에_해당하는_참가자를_반환한다() {
        final Players players = Players.from(List.of("name1", "name2"));

        final Player result = players.get(Position.valueOf(0));

        assertThat(result).isEqualTo(new Player("name1"));
    }

    @Test
    void 모든_참가자의_이름을_반환한다() {
        final Players players = Players.from(List.of("name1", "name2"));

        assertThat(players.getNames()).containsExactly("name1", "name2");
    }
}
