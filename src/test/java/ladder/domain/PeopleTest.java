package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

    @DisplayName("이름을 입력하여 People을 생성한다.")
    @Test
    void peopleConstructTest() {
        assertThatCode(() -> new People(List.of("명오", "제우스")))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test
    void duplicateNameTest() {
        assertThatThrownBy(() -> new People(
                List.of("명오", "명오")
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사람 수를 반환한다.")
    @Test
    void peopleCountTest() {
        People people = new People(List.of("명오", "제우스"));
        assertThat(people.count()).isEqualTo(2);
    }
}
