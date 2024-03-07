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

@DisplayName("사람들")
public class PeopleTest {
    static Stream<List<String>> providePeopleNamesWithException() {
        return Stream.of(
                List.of("pobi"),
                Collections.emptyList()
        );
    }

    @DisplayName("생성 테스트")
    @Test
    void createTest() {
        assertThatCode(() -> new People(List.of("pobi", "nak", "eden")))
                .doesNotThrowAnyException();
    }

    @DisplayName("사람들의 수가 2명 미만이라면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("providePeopleNamesWithException")
    void minItemsTest(List<String> peopleNames) {
        assertThatThrownBy(() -> new People(peopleNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임에 참여하는 사람들의 수는 2명 이상이어야 합니다.");
    }

    @DisplayName("사람의 이름이 중복된다면 예외를 발생시킨다.")
    @Test
    void peopleNamesDuplicationTest() {
        // given
        List<String> peopleNames = List.of("pobi", "pobi", "neo");

        // when & then
        assertThatThrownBy(() -> new People(peopleNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람의 이름은 중복될 수 없습니다.");
    }
}
