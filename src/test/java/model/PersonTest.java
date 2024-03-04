package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import model.path.Path;
import model.path.PathGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

    @DisplayName("사람은 이름과 위치를 갖는다.")
    @Test
    void createPerson() {
        String name = "moly";
        Person person = Person.from(name, 0);
        assertThat(person.getPersonName()).isEqualTo(new PersonName(name));
        assertThat(person.getDepth()).isZero();
        assertThat(person.getColumn()).isZero();
    }

    @ParameterizedTest(name = "이름은 최소 1글자 최대 5글자다.")
    @ValueSource(strings = {"", "mollly"})
    void createPersonThrowExceptionWhenInvalidNameLength(String name) {
        assertThatThrownBy(() -> Person.from(name, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1글자 최대 5글자여야 합니다. " + name + "은(는) 적절한 길이가 아닙니다.");
    }

    @ParameterizedTest(name = "사다리를 타고 올바른 경로로 내려가야 합니다.")
    @CsvSource({"0, 2", "1, 1", "2, 0", "3, 3", "4, 4"})
    void climbDown(int before, int expected) {
        List<Person> personGroup = List.of(Person.from("0", 0), Person.from("1", 1),
                Person.from("2", 2), Person.from("3", 3), Person.from("4", 4));
        Person person = personGroup.get(before);
        List<List<Path>> lines = List.of(
                List.of(Path.EXIST, Path.NOT_EXIST, Path.NOT_EXIST, Path.EXIST),
                List.of(Path.NOT_EXIST, Path.EXIST, Path.NOT_EXIST, Path.EXIST),
                List.of(Path.EXIST, Path.NOT_EXIST, Path.EXIST, Path.NOT_EXIST),
                List.of(Path.NOT_EXIST, Path.NOT_EXIST, Path.EXIST, Path.NOT_EXIST)
        );
        Ladder ladder = Ladder.from(4, new People(personGroup), new TestPathGenerator(lines));

        person.climbDown(ladder);
        int after = person.getColumn();
        assertAll(
                () -> assertThat(after).isEqualTo(expected),
                () -> assertThat(person.getDepth()).isEqualTo(4)
        );
    }

    private static class TestPathGenerator implements PathGenerator {
        private final List<List<Path>> lines;
        private int lineNumber = 0;

        private TestPathGenerator(List<List<Path>> lines) {
            this.lines = lines;
        }

        @Override
        public List<Path> generate(int count) {
            return lines.get(lineNumber++);
        }
    }
}
