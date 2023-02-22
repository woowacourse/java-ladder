package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Line;
import domain.ladder.LineGenerator;
import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름이 같은 Player는 equals true를 반환한다.")
    @Test
    void same_Player_name_return_true() {
        Player playerA = new Player(new Name("hi"), new Position(1));
        Player playerB = new Player(new Name("hi"), new Position(1));

        assertThat(playerA).isEqualTo(playerB);
    }

    @DisplayName("이름이 다른 Player는 equals false를 반환한다.")
    @Test
    void other_Player_name_eqauls_return_false() {
        Player playerA = new Player(new Name("hi"), new Position(1));
        Player playerB = new Player(new Name("bye"), new Position(1));

        assertThat(playerA).isNotEqualTo(playerB);
    }

    @DisplayName("이름이 같으면 true를 반환한다.")
    @Test
    void same_name_return_true() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));

        // then
        assertThat(player.isSameName("name")).isTrue();
    }

    @DisplayName("이름이 다르면 false를 반환한다.")
    @Test
    void different_name_return_false() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));

        // then
        assertThat(player.isSameName("differentName")).isFalse();
    }

    @DisplayName("move시에 우측 이동이 가능하면 position을 1 증가 시킨다.")
    @Test
    void move_to_right_position_plus_one() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(1));
        Line line = generateLine();

        // when
        player.move(line);

        // then
        assertThat(player.getPosition()).isEqualTo(2);
    }

    @DisplayName("move시에 좌측 이동이 가능하면 position을 1 감소 시킨다.")
    @Test
    void move_to_left_position_minus_one() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(2));
        Line line = generateLine();

        // when
        player.move(line);

        // then
        assertThat(player.getPosition()).isEqualTo(1);
    }

    @DisplayName("move시에 아무런 조건을 만족못하면 position이 변하지 않는다.")
    @Test
    void move_not_change_position() {
        // given
        Name name = new Name("name");
        Player player = new Player(name, new Position(3));
        Line line = generateLine();

        // when
        player.move(line);

        // then
        assertThat(player.getPosition()).isEqualTo(3);
    }

    private Line generateLine() {
        LineGenerator lineGenerator = new LineGenerator(() -> 4);
        return lineGenerator.generate(2);
    }
}
