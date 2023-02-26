package domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ItemsTest {

    @Test
    @DisplayName("게임 참가자 수와 입력된 실행 결과의 수가 일치하지 않으면 예외를 발생한다.")
    void createItems_success() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        int playerCount = items.size();
        assertThatNoException().isThrownBy(() -> new Items(playerCount, items));
    }
    @Test
    @DisplayName("게임 참가자 수와 입력된 실행 결과의 수가 일치하지 않으면 예외를 발생한다.")
    void createItems_fail() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000", "꽝");
        int playerCount = items.size() + 1;
        assertThatThrownBy(() -> new Items(playerCount, items))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수와 실행 결과의 수가 일치해야 합니다.");
    }
}
