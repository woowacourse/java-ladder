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
                List.of("명오", "명오")
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @Test
    void nameTest() {
        String name = "우아한테크코스";
        assertThatThrownBy(() -> new People(List.of(name)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
