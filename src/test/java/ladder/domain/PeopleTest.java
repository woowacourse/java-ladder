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
        People people = new People(List.of(
                new Person("pobi"),
                new Person("nakna"),
                new Person("seyan")));
        // then
        assertThat(people)
                .extracting("values")
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("이름이 2개 이상이 아니라면 예외를 발생시킨다.")
    @Test
    void peopleCountExceptionTest() {
        assertThatThrownBy(() -> new People(List.of(new Person("pobi"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임에 참여하는 사람의 수는 2명 이상 이여야 합니다.");
    }
}
