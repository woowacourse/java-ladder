package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.domain.linegenerator.StickListGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Product;
import ladder.domain.product.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("플레이어의 위치에와 사다리에 따라 최종 플레이어의 결과 위치를 찾을 수 있다")
    @ParameterizedTest(name = "초기 위치 : {0}, 최종 위치 : {1}")
    @CsvSource({"0, 1", "1, 0", "2, 2"})
    void progressGameTest(int playerPosition, int expected) {
        /* 0     1     2
        *  |-----|     |
        *  |-----|     |
        *  |-----|     |
        *  0     1     2
        */
        Height height = new Height(3);
        StickListGenerator stickListGenerator = countOfPlayers -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = Ladder.of(height, 3, stickListGenerator);

        int actual = ladder.findResultPosition(playerPosition);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리의 높이를 알 수 있다")
    @Test
    void getHeightTest() {
        Height height = new Height(3);
        StickListGenerator stickListGenerator = countOfPlayers -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = Ladder.of(height, 3, stickListGenerator);
        int expected = height.getValue();

        int actual = ladder.getHeight();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사다리의 길이를 구할 수 있다")
    @Test
    void getWidthTest() {
        int countOfPlayers = 3;
        StickListGenerator stickListGenerator = count -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = Ladder.of(new Height(3), countOfPlayers, stickListGenerator);
        int expected = countOfPlayers - 1;

        int actual = ladder.getWidth();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("특정 좌표에 스틱이 존재하는지 알 수 있다")
    @Test
    void isExistTest() {
        StickListGenerator stickListGenerator = countOfPlayers -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = Ladder.of(new Height(3), 3, stickListGenerator);

        boolean actual = ladder.isExist(2, 1);

        assertThat(actual).isFalse();
    }

    @DisplayName("요청하는 높이가 0보다 작거나 총 높이보다 큰 경우, 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void isExistTest_whenHeightIsOutOfRange(int heightValue) {
        Height height = new Height(3);
        StickListGenerator stickListGenerator = countOfPlayers -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE);
        Ladder ladder = Ladder.of(height, 2, stickListGenerator);
        int widthValue = 0;

        assertThatThrownBy(() -> ladder.isExist(heightValue, widthValue)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이 위치가 범위를 벗어났습니다.");
    }
}
