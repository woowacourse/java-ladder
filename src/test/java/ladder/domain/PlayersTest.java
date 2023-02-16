package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayersTest {

    @Test
    void 참가자가_한_명_이하인_경우_예외를_던진다() {
        assertThatThrownBy(() -> new Players(List.of("name")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 최소 두명이어야 합니다.");
    }

    @Test
    void 참가자가_두_명_이상인_경우_예외를_던지지_않는다() {
        assertThatNoException().isThrownBy(() -> new Players(List.of("name1", "name2")));
    }

    @Test
    void 참가자의_이름은_중복되는_경우_예외를_던진다() {
        assertThatThrownBy(() -> new Players(List.of("name", "name")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 중복되지 않아야 합니다.");
    }

    @Test
    void 모든_참가자의_이름을_반환한다() {
        final Players players = new Players(List.of("name1", "name2"));

        assertThat(players.getNames()).containsExactly("name1", "name2");
    }
}
