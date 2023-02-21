package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class GiftsTest {

    @ParameterizedTest
    @MethodSource("generateInvalidSize")
    @DisplayName("상품의 수와 플레이어의 수가 다르면 예외를 던진다")
    void invalidGiftSize(final List<String> playerNames, final List<String> giftNames) {
        final Players players = new Players(playerNames);

        assertThatThrownBy(() -> new Gifts(giftNames, players.numberOfPlayers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 수는 참여한 플레이어의 수와 같아야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("generateValidSize")
    @DisplayName("상품의 수는 플레이어의 수와 같다")
    void validGiftSize(final List<String> playerNames, final List<String> giftNames, final String[] expected) {
        final Players players = new Players(playerNames);
        final Gifts gifts = new Gifts(giftNames, players.numberOfPlayers());

        assertThat(gifts.getNames())
                .containsExactly(expected);
    }

    @Test
    @DisplayName("특정 위치에 있는 선물을 제대로 가져오는지 확인한다.")
    void findGiftByPosition() {
        // given
        int position = 2;
        Gifts gifts = new Gifts(List.of("1234", "567", "89", "꽝"), 4);
        String expected = "89";

        // when
        String actual = gifts.findNameByPosition(position);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> generateInvalidSize() {
        return Stream.of(
                Arguments.of(
                        List.of("a", "b"),
                        List.of("1", "2", "3")
                ),
                Arguments.of(
                        List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"),
                        List.of("1", "2", "3", "4", "5", "6", "7", "8", "9")
                )
        );
    }

    private static Stream<Arguments> generateValidSize() {
        return Stream.of(
                Arguments.of(
                        List.of("a", "b"),
                        List.of("1", "2"),
                        new String[]{"1", "2"}
                ),
                Arguments.of(
                        List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"),
                        List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"),
                        new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}
                )
        );
    }
}
