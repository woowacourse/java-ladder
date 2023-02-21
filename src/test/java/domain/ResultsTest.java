package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultsTest {

    @DisplayName("실행 결과의 수는 사람 수와 일치해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:user1,user2",
            "꽝,5000,꽝:user1,user2,user3",
            "꽝,5000,꽝,3000:user1,user2,user3,user4",
    }, delimiter = ':')
    void success(String input, String people) {
        assertDoesNotThrow(() -> new Results(input, new People(people)));
    }

    @DisplayName("실행 결과의 수가 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:user1,user2,user3",
            "꽝,5000,꽝:user1,user2,user3,user4",
            "꽝,5000,꽝,3000:user1,user2,user3",
    }, delimiter = ':')
    void fail(String input, String people) {
        assertThatThrownBy(() -> new Results(input, new People(people)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 사람 수와 같아야 합니다.");
    }
}
