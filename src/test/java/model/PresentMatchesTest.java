package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PresentMatchesTest {

    @ParameterizedTest(name = "사람과 매칭된 선물을 기록하는 객체를 만듭니다.")
    @CsvSource({"1, 'q'", "2, 'w'", "3, 'e'", "4, 'r'", "5, 't'"})
    void createPresentMatches(String finding, String expected) {
        HashMap<PersonName, Present> matches = new HashMap<>(Map.of(
                new PersonName("1"), new Present("q"),
                new PersonName("2"), new Present("w"),
                new PersonName("3"), new Present("e"),
                new PersonName("4"), new Present("r"),
                new PersonName("5"), new Present("t")
        ));
        PresentMatches presentMatches = new PresentMatches(matches);
        PersonName personName = new PersonName(finding);
        Present present = presentMatches.findByPersonName(personName);
        String presentName = present.name();
        assertThat(presentName).isEqualTo(expected);
    }
}
