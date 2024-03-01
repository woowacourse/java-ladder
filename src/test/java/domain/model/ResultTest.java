package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @ParameterizedTest
    @CsvSource({
            "a,30",
            "b,10",
            "c,20"
    })
    @DisplayName("사다리 게임 결과를 담는다")
    void makeResultTest(String person, String consequence) {
        //given
        People people = new People(List.of("a", "b", "c"));
        Consequences consequences = new Consequences(List.of("10", "20", "30"), 3);
        Result result = new Result(people, consequences);

        //when
        result.make(0, 2);
        result.make(1, 0);
        result.make(2, 1);

        //then
        assertThat(result.showConsequence(new Person(person))).isEqualTo(consequence);
    }
}
