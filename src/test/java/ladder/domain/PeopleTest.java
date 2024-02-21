package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PeopleTest {

    @DisplayName("중복된 이름은 입력할 수 없다.")
    @Test
    void peopleTest() {
        assertThatThrownBy(() -> new People(
                List.of(
                        "명오", "명오"
                )
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
