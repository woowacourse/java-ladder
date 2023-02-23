package domain;

import domain.Collection.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {
    @Test
    @DisplayName("결과는 1자 이상 5자 이하이다.")
    void generateValidResult() {
        Result result = Result.from("1000");
        assertThat(result.getValue()).isEqualTo("1000");
    }

    @Test
    @DisplayName("결과가 1자 미만이면 예외가 발생한다.")
    void generateInvalidResult1() {
        assertThatThrownBy(() -> {
            Result.from("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과가 5자 이상이면 예외가 발생한다.")
    void generateInvalidResult2() {
        assertThatThrownBy(() -> {
            Result.from("500000");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과값이 같으면 같은 객체를 반환한다.")
    void createSameResultTest(){
        Result result1 = Result.from("꽝");
        Result result2 = Result.from("꽝");
        assertThat(result1.equals(result2)).isTrue();
        Result result3 = Result.from("3000");
        assertThat(result1.equals(result3)).isFalse();
    }
}
