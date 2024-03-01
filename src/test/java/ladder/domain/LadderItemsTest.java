package ladder.domain;

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
                        List.of(new Person("pobi")),
                        List.of(new WinningItem("1등"), new WinningItem("2등"))
                ),
                Arguments.of(
                        List.of(new Person("pobi"), new Person("neo")),
                        List.of(new WinningItem("1등"))
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
        List<Person> people = List.of(
                new Person("pobi"), new Person("nak"), new Person("neo"));
        List<WinningItem> winningItems = List.of(
                new WinningItem("1등"), new WinningItem("2등"), new WinningItem("3등"));

        // when & then
        assertThatCode(() -> new LadderItems(people, winningItems))
                .doesNotThrowAnyException();
    }

    @DisplayName("각 아이템의 개수가 2개 미만이라면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("provideItemsWithException")
    void minItemsTest(List<Person> people, List<WinningItem> winningItems) {
        assertThatThrownBy(() -> new LadderItems(people, winningItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임의 아이템들의 개수는 각각 2개 이상이어야 합니다.");
    }
}
