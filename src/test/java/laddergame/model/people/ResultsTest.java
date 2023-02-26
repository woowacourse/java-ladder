package laddergame.model.people;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultsTest {
    Result result1 = new Result(new Person("tori"), new Prize("100"));
    Result result2 = new Result(new Person("pobi"), new Prize("200"));
    Result result3 = new Result(new Person("mango"), new Prize("300"));
    Result result4 = new Result(new Person("bero"), new Prize("400"));

    Results results = new Results(List.of(result1, result2, result3, result4));

    @ParameterizedTest(name = "{displayName} [{index}] ==> {0} : ''{1}''")
    @CsvSource(value = {"tori:100", "pobi:200", "mango:300", "bero:400"}, delimiter = ':')
    @DisplayName("해당 참여자의 결과를 반환")
    void Should_Prize_When_PersonName(String name, String prize) {
        assertThat(results.findResultOfPerson(name).getPrizeToString()).isEqualTo(prize);
    }

}
