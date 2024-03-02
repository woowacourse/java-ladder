package ladder.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 아이템")
public class LadderItemsTest {
    static Stream<Arguments> provideItemsWithException() {
        return Stream.of(
                Arguments.of(
                        List.of("pobi"),
                        List.of("1등", "2등")
                ),
                Arguments.of(
                        List.of("pobi", "neo"),
                        List.of("1등")
                ),
                Arguments.of(
                        Collections.emptyList(),
                        Collections.emptyList()
                )
        );
    }

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        // given
        List<String> peopleNames = List.of("pobi", "nak", "neo");
        List<String> winningItemNames = List.of("1등", "2등", "3등");

        // when & then
        assertThatCode(() -> LadderItems.of(peopleNames, winningItemNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("각 아이템의 개수가 2개 미만이라면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideItemsWithException")
    void minItemsTest(List<String> peopleNames, List<String> winningItemNames) {
        assertThatThrownBy(() -> LadderItems.of(peopleNames, winningItemNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임의 아이템들의 개수는 각각 2개 이상이어야 합니다.");
    }

    @DisplayName("사람의 수와 당첨 아이템의 개수가 동일하지 않으면 예외를 발생시킨다.")
    @Test
    void countNotSameTest() {
        // given
        List<String> peopleNames = List.of("pobi", "nak", "neo");
        List<String> winningItemNames = List.of("1등", "2등", "3등", "4등");

        // when & then
        assertThatThrownBy(() -> LadderItems.of(peopleNames, winningItemNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 수와 당첨 아이템의 개수는 동일해야 합니다.");
    }
}
