package ladder.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningItemsTest {
    static Stream<List<String>> provideWinningItemNamesWithException() {
        return Stream.of(
                List.of("당첨"),
                Collections.emptyList()
        );
    }

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThatCode(() -> new WinningItems(List.of("당첨", "당첨", "꽝")))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 아이템의 수가 2개 미만이라면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideWinningItemNamesWithException")
    void minItemsTest(List<String> winningItemNames) {
        assertThatThrownBy(() -> new WinningItems(winningItemNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 아이템의 수는 2개 이상이어야 합니다.");
    }
}
