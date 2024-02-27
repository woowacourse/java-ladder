package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultsTest {
    @Test
    @DisplayName("Players, Prizes를 통해 생성한다.")
    void createSuccess() {
        assertThatCode(() -> PrizeResults.of(
                        new Players(List.of("wiib", "pobi", "haha")),
                        new Prizes(List.of("꽝", "당첨", "꽝"))
                )
        ).isInstanceOf(PrizeResults.class)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Players, Prizes의 Size가 다르면 예외를 발생한다.")
    void createFailRange() {
        assertThatCode(() -> PrizeResults.of(
                new Players(List.of("wiib", "pobi", "haha")),
                new Prizes(List.of("꽝", "당첨", "꽝", "당첨"))
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("실행 결과는 참여자와 같은 갯수를 입력해주세요. 입력 : %d개", 4));
    }

    @Test
    @DisplayName("all을 입력하면 false, 그 외의 입력에 대해서는 true을 리턴한다.")
    void checkOperate() {
        PrizeResults prizeResults = PrizeResults.of(
                new Players(List.of("wiib", "pobi", "haha")),
                new Prizes(List.of("꽝", "당첨", "꽝")));

        assertThat(prizeResults.checkOperate("all")).isFalse();
        assertThat(prizeResults.checkOperate("wiib")).isTrue();
    }

    @Test
    @DisplayName("all 또는 사용자 이름과 다를 경우, 예외를 발생한다.")
    void checkOperateValidation() {
        PrizeResults prizeResults = PrizeResults.of(
                new Players(List.of("wiib", "pobi", "haha")),
                new Prizes(List.of("꽝", "당첨", "꽝")));

        assertThatCode(() -> prizeResults.checkOperate("atom"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("보고 싶은 결과는 all 또는 사용자 이름으로 입력해주세요. 입력 : %s", "atom"));
    }
}
