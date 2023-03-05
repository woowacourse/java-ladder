package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {

    @Test
    @DisplayName("Results는 필드로 받은 이름들을 ,를 기준으로 나눈다.")
    void test_1() {
        // given & when
        Results results = new Results("coco,fefe", 2);
        List<String> expected = List.of("coco", "fefe");

        // then
        assertThat(results.getResults()).isEqualTo(expected);
    }

    @Test
    @DisplayName("각 실행결과는 다섯글자 초과로 받으면 예외처리 한다.")
    void test_3() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results("abcdef,abc", 2))
                .withMessage("입력된 실행결과의 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("결과의 개수는 사람이름 수와 같아야 한다.")
    void test_4() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results("abc,efg", 3))
                .withMessage("사람 수와 결과의 개수가 같아야 합니다.");
    }
}
