package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    @DisplayName("Names는 필드로 받은 이름들을 ,를 기준으로 나눈다.")
    void test_1() {
        // given & when
        Names names = new Names("coco,fefe");
        List<String> expected = List.of("coco", "fefe");

        // then
        assertThat(names.getNames()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "input : {0}")
    @EmptySource
    @DisplayName("null, blank를 입력받으면 예외처리 한다.")
    void test_2(String input) {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names(input))
                .withMessage("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("각 이름은 다섯글자 초과로 받으면 예외처리 한다.")
    void test_3() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("12345,123"))
                .withMessage("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("사람 이름을 두명보다 적게 받으면 예외처리 한다.")
    void test_4() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("123"))
                .withMessage("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("이름을 중복으로 받으면 예외처리 한다.")
    void test_5() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Names("123,123"))
                .withMessage("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
    }
}
