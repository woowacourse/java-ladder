package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("add 메서드는 내부 컬렉션에 Line을 추가한다.")
    void addTest() {
        Ladder ladder = new Ladder();

        Line line = new Line(List.of(false, true, true));
        ladder.add(line);

        assertThat(ladder.getLines()).contains(line);
    }
}
