package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    void success(String results, String people) {
        List<String> names = Arrays.stream(people.split(",")).collect(Collectors.toList());
        List<String> resultList = Arrays.stream(results.split(",")).collect(Collectors.toList());
        assertDoesNotThrow(() -> new Results(resultList));
    }

    @DisplayName("실행 결과의 수가 일치하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "꽝,5000:user1,user2,user3",
            "꽝,5000,꽝:user1,user2,user3,user4",
            "꽝,5000,꽝,3000:user1,user2,user3",
    }, delimiter = ':')
    void fail(String results, String people) {
        List<String> names = Arrays.stream(people.split(",")).collect(Collectors.toList());
        List<String> resultList = Arrays.stream(results.split(",")).collect(Collectors.toList());
        assertThatThrownBy(() -> new Results(resultList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 사람 수와 같아야 합니다.");
    }
}
