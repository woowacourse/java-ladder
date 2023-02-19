package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private final PointGenerator pointGenerator = new RandomPointGenerator();

    @Test
    @DisplayName("0이하의 값으로 Ladder생성시 예외가 발생한다.")
    void inValidLadderSizeTest() {

        assertThatThrownBy(() -> new Ladder(0, new Users(List.of("1", "2")), pointGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ladder 생성시 1이상의 height를 입력하면 정상 생성된다..")
    void checkValidLadderSizeTest() {

        var users = new Users(List.of("1", "2"));
        var ladder = new Ladder(1, users, pointGenerator);

        assertThat(ladder.getFloors().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Ladder 생성시 users보다 1작은 width로 생성된다.")
    void checkLadderWidthTest() {

        var users = new Users(List.of("1", "2", "3"));

        var ladder = new Ladder(3, users, pointGenerator);

        List<Floor> floors = ladder.getFloors();
        for (Floor floor : floors) {
            assertThat(floor.getPoints().size()).isEqualTo(users.getUsers().size() - 1);
        }
    }
}
