package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사람들")
public class PeopleTest {
    @DisplayName("객체를 생성한다.")
    @Test
    void createTest() {
        // given
        String names = "pobi,nakna,seyan";
        List<Person> expected =
                List.of(new Person("pobi"), new Person("nakna"), new Person("seyan"));

        // when
        People people = People.from(names);

        // then
        assertThat(people)
                .extracting("values")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("콤마로 구분된 이름이 2개 이상이 아니라면 예외를 발생시킨다.")
    @Test
    void peopleCountExceptionTest() {
        assertThatThrownBy(() -> People.from("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
