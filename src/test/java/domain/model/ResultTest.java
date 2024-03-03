package domain.model;

import domain.model.consequence.Consequence;
import domain.model.ladder.Result;
import domain.model.participant.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        Result result = new Result();

        //when
        result.make(new Person("a"), new Consequence("30"));
        result.make(new Person("b"), new Consequence("10"));
        result.make(new Person("c"), new Consequence("20"));

        //then
        assertThat(result.showConsequence(new Person(person))).isEqualTo(consequence);
    }
}
