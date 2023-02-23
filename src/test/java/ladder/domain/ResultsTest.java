package ladder.domain;

import static ladder.Util.createPlayers;
import static ladder.Util.createResults;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultsTest {

    @Test
    @DisplayName("실행 결과의 갯수가 참여하는 인원과 같지 않으면 예외가 발생한다.")
    void create_notEqualsPlayersCount() {
        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Prizes(createResults(5), createPlayers(4)))
                .withMessage("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
    }

    @Test
    @DisplayName("실행 결과가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException()
                .isThrownBy(() -> new Prizes(createResults(5), createPlayers(5)));
    }

    @Test
    @DisplayName("인덱스로 Result를 찾을 수 있어야 한다.")
    void findResultByIndex_success() {
        // given
        Prizes prizes = new Prizes(createResults(5), createPlayers(5));

        // when
        Prize prize = prizes.findPrizeByIndex(1);

        // then
        Prize expectPrize = prizes.getPrizes().get(1);
        assertThat(prize)
                .isEqualTo(expectPrize);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5, 6})
    @DisplayName("인덱스로 Result를 찾을때 범위를 초과하면 예외가 발생한다.")
    void findByResultByIndex_wrongIndex(int index) {
        // given
        Prizes prizes = new Prizes(createResults(4), createPlayers(4));

        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> prizes.findPrizeByIndex(index))
                .withMessage("[ERROR] 인덱스 범위를 초과했습니다.");
    }
}
