package domain;

import exception.InvalidLadderCountException;
import exception.InvalidLadderHeightException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapTest {

    @DisplayName("높이와 참가자의 수가 조건에 맞는 경우 객체를 생성한다.")
    @Test
    void mapSuccess() {
        try {
            new Map("3", 3);
        } catch (IllegalArgumentException exception) {
            Assertions.fail("높이가 숫자인 경우 객체가 생성되어야 합니다.");
        }
    }

    @DisplayName("높이가 숫자가 아닌 경우 오류를 던진다.")
    @Test
    void heightNotDigit() {
        Assertions.assertThatThrownBy(() -> new Map("a", 2)).isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("높이가 null일 경우 오류를 던진다.")
    @Test
    void heightNull() {
        Assertions.assertThatThrownBy(() -> new Map(null, 2)).isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("높이가 공백으로만 이루어져 있을 경우 오류를 던진다.")
    @Test
    void heightBlank() {
        Assertions.assertThatThrownBy(() -> new Map("     ", 2))
            .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("참가자 수가 10명보다 많은 경우 오류를 던진다.")
    @Test
    void ladderCountOver10() {
        Assertions.assertThatThrownBy(() -> new Map("3", 11)).isExactlyInstanceOf(InvalidLadderCountException.class);
    }

    @DisplayName("참가자 수가 2명보다 적은 경우 오류를 던진다.")
    @Test
    void ladderCountUnder1() {
        Assertions.assertThatThrownBy(() -> new Map("3", 1)).isExactlyInstanceOf(InvalidLadderCountException.class);
    }

    @DisplayName("참가자 수에서 1을 뺀 만큼의 사다리를 만든다.")
    @Test
    void generateLadder() {
        Map map = new Map("3", 3);
        map.generate(() -> true);
        List<Ladder> ladders = map.getLadders();
        Assertions.assertThat(ladders.get(0).getStatus()).containsExactly(true, true, true);
        Assertions.assertThat(ladders.get(1).getStatus()).containsExactly(false, false, false);
    }
}
