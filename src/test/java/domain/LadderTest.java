package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.LineTest.FixedBooleanGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    public void create() {
        Ladder ladder = new Ladder(new Players(List.of("pobi", "tommy")), new Height(5),
                new FixedBooleanGenerator(true));

        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @DisplayName("사다리가 반환한 다리들을 변경하면 UnsupportedOperationException이 반환된다")
    @Test
    public void getLines() {
        Ladder ladder = new Ladder(new Players(List.of("pobi", "tommy")), new Height(5),
                new FixedBooleanGenerator(true));

        assertAll(
                () -> assertThatCode(() -> ladder.getLines().add(new Line(3, () -> true)))
                        .isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatCode(() -> ladder.getLines().set(0, new Line(3, () -> true)))
                        .isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatCode(() -> ladder.getLines().remove(0))
                        .isInstanceOf(UnsupportedOperationException.class),
                () -> assertThatCode(() -> ladder.getLines().clear())
                        .isInstanceOf(UnsupportedOperationException.class)
        );
    }
}
