package domain;

import exception.EmptyInputException;
import exception.InvalidResultsCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ResultsTest {

    @DisplayName("실행 결과의 값이 조건에 맞는다면 객체를 생성한다.")
    @Test
    void createSuccess() {
        Results results = new Results("a,b,c", 3);
        Assertions.assertThat(results.getResult().get(0).getResult()).isEqualTo("a");
        Assertions.assertThat(results.getResult().get(1).getResult()).isEqualTo("b");
        Assertions.assertThat(results.getResult().get(2).getResult()).isEqualTo("c");
    }

    @DisplayName("실행 결과를 입력하지 않은 경우 오류를 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void resultsNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> new Results(input, 2))
                  .isExactlyInstanceOf(EmptyInputException.class);
    }

    @DisplayName("실행 결과 공백으로만 있는 경우 오류를 반환한다.")
    @Test
    void resultsBlank() {
        Assertions.assertThatThrownBy(() -> new Results("   ", 2))
                  .isExactlyInstanceOf(EmptyInputException.class);
    }

    @DisplayName("실행 결과 개수가 사람 수와 다른 경우 오류를 반환한다.")
    @Test
    void resultNotMatchParticipantsCount() {
        Assertions.assertThatThrownBy(() -> new Results("a,b,c", 4))
                  .isExactlyInstanceOf(InvalidResultsCount.class);
    }
}
