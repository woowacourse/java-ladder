package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizesTest {

    @DisplayName("플레이어의 수와 상품들의 수가 다르면 에러가 발생한다")
    @ParameterizedTest
    @MethodSource("createFailByNonMatchedCountArguments")
    public void createFailByNonMatchedCount(Players players, List<String> inputPrizes) {
        assertThatCode(() -> new Prizes(players, inputPrizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 결과의 수는 플레이어의 수와 일치해야 합니다. 입력한 결과 수: %d", inputPrizes.size()));
    }

    static Stream<Arguments> createFailByNonMatchedCountArguments() {
        return Stream.of(
                arguments(new Players(List.of("pobi", "tommy")), List.of("꽝")),
                arguments(new Players(List.of("pobi", "tommy", "paul")), List.of("꽝", "당첨", "꽝", "당첨2"))
        );
    }

    @DisplayName("플레이어의 수와 상품들의 수가 같으면 에러가 발생하지 않는다")
    @ParameterizedTest
    @MethodSource("createSuccessArguments")
    public void createSuccess(Players players, List<String> inputPrizes) {
        assertThatCode(() -> new Prizes(players, inputPrizes))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> createSuccessArguments() {
        return Stream.of(
                arguments(new Players(List.of("pobi", "tommy")), List.of("꽝", "당첨")),
                arguments(new Players(List.of("pobi", "tommy", "paul", "smith", "dean")),
                        List.of("꽝", "당첨", "꽝", "당첨", "꽝"))
        );
    }

    @DisplayName("입력한 상품들을 반환한다")
    @Test
    public void getPrizes() {
        Players players = new Players(List.of("pobi", "tommy"));
        Prizes prizes = new Prizes(players, List.of("꽝", "당첨"));

        assertThat(prizes.getPrizes()).isEqualTo(List.of(new Prize("꽝"), new Prize("당첨")));
    }

    @DisplayName("상품들중 일치하는 인덱스의 상품을 반환한다")
    @Test
    public void getPrizeNameOf() {
        Players players = new Players(List.of("pobi", "tommy"));
        Prizes prizes = new Prizes(players, List.of("꽝", "당첨"));

        assertThat(prizes.getPrizeIndexOf(0)).isEqualTo(new Prize("꽝"));
        assertThat(prizes.getPrizeIndexOf(1)).isEqualTo(new Prize("당첨"));
    }
}
