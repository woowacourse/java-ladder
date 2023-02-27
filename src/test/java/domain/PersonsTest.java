package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonsTest {
    @Nested
    @DisplayName("이름")
    class AboutName {
        @Test
        @DisplayName("중복된 이름은 안된다")
        void duplicateName() {
            assertThatThrownBy(() -> Persons.from(List.of("baron1", "baron2", "oing")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복이 아닌 이름은 가능하다")
        void notDuplicateName() {
            assertDoesNotThrow(() -> Persons.from(List.of("baron", "oing")));
        }
    }

    @Nested
    @DisplayName("위치")
    class AboutPosition {
        @Test
        @DisplayName("각 사람의 시작 위치는 입력 순서대로")
        void personInitialPositionTest() {
            //given
            List<String> names = List.of("오잉", "바론", "홍고");

            //when
            Persons persons = Persons.from(names);

            //then
            assertThat(persons.getAllPersonPosition()).containsExactly(0, 1, 2);
        }

        @Test
        @DisplayName("해당 위치에 있는 사람의 이름을 제대로 반환하는지")
        void findPersonNameInPositionTest() {
            //given
            Persons persons = Persons.from(List.of("oing", "baron", "woowa"));

            //when
            String name = persons.findPersonNameInPosition(1);

            //then
            assertThat(name).isEqualTo("baron");
        }
    }
}
