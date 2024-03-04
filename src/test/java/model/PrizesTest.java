package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizesTest {
    @DisplayName("Prizes 객체에 null 값이 입력되면 예외가 발생한다")
    @Test
    void validatePrizesSizeWhenNull() {
        List<Prize> emptyInput = null;
        assertThatThrownBy(() -> new Prizes(emptyInput, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Prizes 객체에 0개의 값이 입력되면 예외가 발생한다")
    @Test
    void validatePrizesSizeWhenZero() {
        List<Prize> blankInput = List.of();
        assertThatThrownBy(() -> new Prizes(blankInput, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 당첨 프라이즈 수를 반환한다.")
    @Test
    void getPrizesSize() {
        List<Prize> entirePrizes = List.of(
                new Prize("3,000"),
                new Prize("5,000")
        );

        Prizes prizes = new Prizes(entirePrizes, 2);
        int result = prizes.getSize();

        assertThat(result).isEqualTo(entirePrizes.size());
    }

    @DisplayName("Prizes 객체에 입력된 당첨 프라이즈 수가 참여자 수와 일치하지 않으면 예외가 발생한다.")
    @Test
    void validatePrizesSizeDoesNotMatchParticipantsSize() {
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash")
        ));

        assertThatThrownBy(() -> new Prizes(
                List.of(
                        new Prize("꽝"),
                        new Prize("3,000"),
                        new Prize("2,000")
                ), participants.getSize()
        ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
