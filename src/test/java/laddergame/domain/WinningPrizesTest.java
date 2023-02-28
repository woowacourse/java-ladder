package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningPrizesTest {

    @Test
    @DisplayName("리스트의 길이가 플레이어수와 다르면 예외처리한다.")
    void givenDifferentCount_thenFail() {
        //given
        final List<String> prizes = List.of("꽝", "5000", "꽝", "당첨");
        final int playerCount = 5;

        //then
        assertThatThrownBy(() -> WinningPrizes.of(prizes, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과수가 플레이어수와 일치하지 않습니다.");

    }

    @Test
    @DisplayName("findMaxNameLength() 메서드를 호출하면 가장 긴 상품의 이름을 반환한다.")
    void findMaxNameLengthTest() {
        //given
        final List<String> prizes = List.of("꽝", "5000", "꽝", "당첨");
        final int playerCount = 4;
        final WinningPrizes winningPrizes = WinningPrizes.of(prizes, playerCount);

        //when
        final int maxNameLength = winningPrizes.findMaxNameLength();

        //then
        assertThat(maxNameLength).isEqualTo("5000".length());
    }

    @Test
    @DisplayName("index를 입력하면 해당되는 상품을 반환한다.")
    void givenIndex_thenReturnWinningPrize() {
        //given
        final List<String> prizes = List.of("꽝", "5000", "꽝", "당첨");
        final int playerCount = 4;
        final WinningPrizes winningPrizes = WinningPrizes.of(prizes, playerCount);

        //when
        final WinningPrize fourthPrize = winningPrizes.getIndexPrize(3);

        //then
        assertThat(fourthPrize.getWinningPrize())
                .isEqualTo(prizes.get(3));
    }
}
