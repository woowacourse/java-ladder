package laddergame.domain;

import static laddergame.TestDummy.NAME_SIZE_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("참여자")
class PersonalNamesTest {

    @DisplayName("생성된다.")
    @Test
    void create() {
        //given
        final List<String> personalNames = List.of("hyena", "rosie");

        //when
        //then
        assertDoesNotThrow(() -> new PersonalNames(personalNames));
    }

    @Test
    void throwExceptionWhenNameListHasOneElement() {
        //given
        final List<String> personalNames = List.of("rosie");

        //when, then
        assertThatThrownBy(() -> new PersonalNames(personalNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록이 비어있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsEmpty() {
        //given
        final List<String> personalNames = List.of();

        //when
        //then
        assertThatThrownBy(() -> new PersonalNames(personalNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름 목록의 크기를 가져온다.")
    @Test
    void getSize() {
        //given
        final List<String> names = List.of("rosie", "hyena");
        final PersonalNames personalNames = new PersonalNames(names);

        //when
        final int totalSize = personalNames.getSize();

        //then
        assertThat(totalSize).isEqualTo(names.size());
    }

    @DisplayName("이름 목록을 가져온다.")
    @Test
    void getNameList() {
        //given, when
        final List<PersonalName> names = NAME_SIZE_2.getPersonalNames();
        final List<String> nameValues = names.stream().map(PersonalName::getValue).collect(Collectors.toList());
        //then
        assertThat(nameValues).containsExactly("hyena", "rosie");
    }

    @DisplayName("중복인 이름이 있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNameDuplicated() {
        //given
        final List<String> name = List.of("rosie", "rosie", "hihi");
        //when
        //then
        assertThatThrownBy(() -> new PersonalNames(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
