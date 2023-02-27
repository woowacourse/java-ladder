package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어는 ")
class PlayerTest {

    @Nested()
    @DisplayName("생성 시 ")
    class Generate {

        @Test
        @DisplayName("올바른 이름과 시작 올바른 시작 위치를 받아서 생성한다.")
        void generatePlayerCase() {
            //given
            Name name = new Name("pobi");
            Position startPosition = new Position(0);

            //when
            Player player = new Player(name, startPosition);

            //then
            assertThat(player.getPosition())
                    .isEqualTo(startPosition.getPosition());
        }
    }

    @Nested
    @DisplayName("움직일 때 ")
    class MoveCase {
        @Test
        @DisplayName(" 밟은 위치에 따라 해당 방향으로 위치를 옮긴다.")
        void givenPositionValue_thenMovePosition() {
            //given
            Player player = new Player(new Name("Pobi"), new Position(0));

            //then
            player.move(Step.RIGHT);

            //then
            assertThat(player.getPosition())
                    .isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("이름이")
    class EqualsCase {
        @Test
        @DisplayName("같다면 위치가 달라도 같다고 판단한다.")
        void equalsTest() {
            //given
            Player player1 = new Player(new Name("Pobi"), new Position(0));
            Player player2 = new Player(new Name("Pobi"), new Position(1));

            //then
            boolean isSamePlayer = player1.equals(player2);

            //then
            assertThat(isSamePlayer)
                    .isTrue();
        }
    }
}
