package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @ParameterizedTest(name = "입력된 참여자 = {0}, 입력된 실행 결과 = {1}")
    @DisplayName("입력된 실행 결과들의 수가 참여자의 수와 일치하는지 확인한다.")
    @MethodSource("resultsAndUsersNumberDummy")
    void resultsNumberSameUsersNumber(List<String> usersName, List<String> resultsName) {
        Users users = new Users(usersName);
        int usersNumber = users.getUsersName().size();

        Results results = new Results(resultsName, usersNumber);

        assertThat(results.getResultsName().size()).isEqualTo(usersNumber);
    }

    static Stream<Arguments> resultsAndUsersNumberDummy() {
        return Stream.of(
                Arguments.arguments(List.of("pobi"), List.of("꽝")),
                Arguments.arguments(List.of("pobi", "crong", "honux", "jk"), List.of("꽝", "5000", "3000", "꽝"))
        );
    }
}
