package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PresentMatchesTest {

    @ParameterizedTest(name = "사람과 매칭된 선물을 기록하는 객체를 만듭니다.")
    @CsvSource({"1, 'q'", "2, 'w'", "3, 'e'", "4, 'r'", "5, 't'"})
    void createPresentMatches(String finding, String expected) {
        People people = People.from(List.of("1", "2", "3", "4", "5"));
        Presents presents = Presents.from(List.of("q", "w", "e", "r", "t"), 5);
        PresentMatches presentMatches = PresentMatches.from(people, presents);
        PersonName personName = new PersonName(finding);
        Present present = presentMatches.findByPersonName(personName);
        String presentName = present.name();
        assertThat(presentName).isEqualTo(expected);
    }
}