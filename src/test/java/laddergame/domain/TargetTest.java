package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TargetTest {
    @DisplayName("입력이 유저 네임이 아니고 all 도 아닐 때 에러 확인")
    @Test
    void checkContent() {
        Target target = new Target("extra");
        Players player = new Players(List.of("pobi", "crong", "jena"));
        List<String> playerNames = player.getPlayers().stream().map(Player::getName).collect(Collectors.toList());
        Assertions.assertThatThrownBy(() -> target.checkNotPlayerNameOrNotKeyword(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 유저 네임이거나 all 일 때 성공")
    @Test
    void checkContent2() {
        Players player = new Players(List.of("pobi", "crong", "jena"));
        List<String> playerNames = player.getPlayers().stream().map(Player::getName).collect(Collectors.toList());
        assertDoesNotThrow(() -> new Target("jena").checkNotPlayerNameOrNotKeyword(playerNames));
        assertDoesNotThrow(() -> new Target("all").checkNotPlayerNameOrNotKeyword(playerNames));
    }
}
