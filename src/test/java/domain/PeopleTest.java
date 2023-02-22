package domain;

import helper.AbstractTestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleTest extends AbstractTestFixture {

    @Test
    @DisplayName("peopleConstructor() : 참가자가 2명 미만이면 IllegalArgumentException을 반환합니다.")
    void test_peopleConstructor_participantSize_IllegalArgumentException() throws Exception {
        //given
        List<Person> defaultPeople = List.of(new Person("aa"));

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> new People(defaultPeople));
    }

    @Test
    @DisplayName("peopleConstructor() : 참가자들의 이름은 중복될 수 없습니다.")
    void test_peopleConstructor_duplicatedName_IllegalArgumentException() throws Exception {
        //given

        List<Person> defaultPeople = List.of(
                new Person("aa"),
                new Person("aa"),
                new Person("bb")
        );

        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> new People(defaultPeople));
    }

    @Test
    @DisplayName("peopleConstructor() : 참가자들의 이름 모두 1글자 이상, 5글자 이하이며 중복되지 않는다면 정상적으로 People이 생성될 수 있습니다.")
    void test_peopleConstructor_success() throws Exception {
        //given
        List<Person> defaultPeople = List.of(
                new Person("aa"),
                new Person("bb"),
                new Person("cc")
        );

        //when & then
        assertDoesNotThrow(() -> new People(defaultPeople));
    }

    @Test
    @DisplayName("[참가자 있을 경우] findPersonByName() : name을 통해 참가자들을 조회할 수 있다.")
    void test_findPersonByName_Present() throws Exception {
        //given
        People people = createDefaultPerson();

        //when
        Optional<Person> participant = people.findPersonByName("aa");

        //then
        assertAll(
                () -> assertTrue(participant.isPresent()),
                () -> assertEquals(participant.get().getName(), "aa")
        );
    }

    @Test
    @DisplayName("[참가자 없을 경우] findPersonByName() : name을 통해 참가자들을 조회할 수 있다.")
    void test_findPersonByName_Empty() throws Exception {
        //given
        People people = createDefaultPerson();

        //when
        Optional<Person> participant = people.findPersonByName("cc");

        //then
        assertTrue(participant.isEmpty());
    }
}
