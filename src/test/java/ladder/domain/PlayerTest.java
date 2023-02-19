package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {

    @Test
    @DisplayName("참여자는 이름을 가질 수 있다.")
    void should_Success_When_CreatePlayerWithName() {
        Player player = new Player("이름");

        assertThat(player.getName()).isEqualTo("이름");
    }
}
