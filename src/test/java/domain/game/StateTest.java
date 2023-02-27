package domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 진행 상태는")
class StateTest {

    @Test
    @DisplayName("처음 생성에는 실행되지 않은 상태이다.")
    void generateStateTest() {
        assertThat(new State().isPlayed()).isFalse();
    }

    @Test
    @DisplayName("생성 이후 상태를 한번 뒤집으면 플레이된 상태이다.")
    void flipStateTest() {
        //given
        State state = new State();

        //when
        state.flipState();

        //then
        assertThat(state.isPlayed()).isTrue();
    }
}
