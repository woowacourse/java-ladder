package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultsTest {

    @Test
    @DisplayName("Results 객체 생성 성공: 사람 수 만큼 입력")
    void results_ok() {
        Results results = Results.from(4, "꽝,1000,꽝,1000");
        assertThat(results.getNames()).containsExactly("꽝", "1000", "꽝", "1000");
    }

    @Test
    @DisplayName("Results 객체 생성 성공: 쉼표 좌우 공백 정상 처리")
    void results_ok_namesWithSpace() {
        Results results = Results.from(4, "  꽝 ,   1000 , 꽝 ,  1000  ");
        assertThat(results.getNames()).containsExactly("꽝", "1000", "꽝", "1000");
    }

    @Test
    @DisplayName("Results 객체 생성 실패: 비정상 공백 처리")
    void results_exception_namesWithSpace() {
        assertThatCode(() -> Results.from(4, "꽝,1000,꽝,10 00"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Results 객체 생성 실패: 사람 수에 맞지 않게 입력")
    void results_exception_doesntMatchMemberCount() {
        assertThatThrownBy(() -> Results.from(3, "꽝,1000,꽝,1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",,꽝,1000", "꽝,1000,,", ",꽝,1000,", ",,,"})
    @DisplayName("Results 객체 생성 실패: 올바르지 않은 쉼표 입력")
    void results_exception_illegalDelimiter(String rawNames) {
        assertThatThrownBy(() -> Results.from(4, rawNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("Results 객체 생성 실패: null, empty")
    void results_exception_null_empty(String rawNames) {
        assertThatThrownBy(() -> Results.from(1, rawNames))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
