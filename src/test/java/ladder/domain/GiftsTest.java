package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GiftsTest {
    private static final String COMMA = ",";

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,6,7,8,9"})
    @DisplayName("상품의 수와 플레이어의 수가 다르면 예외를 던진다")
    void invalidGiftSize(final String giftNamesRawData) {
        final List<String> giftNames = List.of(giftNamesRawData.split(COMMA));

        assertThatThrownBy(() -> new Gifts(giftNames, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 수는 참여한 플레이어의 수와 같아야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1,2:1,2", "10:1,2,3,4,5,6,7,8,9,10:1,2,3,4,5,6,7,8,9,10"}, delimiter = ':')
    @DisplayName("상품의 수는 플레이어의 수와 같다")
    void validGiftSize(final int numberOfPlayers, final String giftNamesRawData, final String expectedRawData) {
        final List<String> giftNames = List.of(giftNamesRawData.split(COMMA));
        final String[] expected = expectedRawData.split(COMMA);

        final Gifts gifts = new Gifts(giftNames, numberOfPlayers);

        assertThat(gifts.getNames())
                .containsExactly(expected);
    }

    @Test
    @DisplayName("특정 위치에 있는 선물을 제대로 가져오는지 확인한다.")
    void findGiftByPosition() {
        // given
        final int position = 2;
        final Gifts gifts = new Gifts(List.of("1234", "567", "89", "꽝"), 4);
        final String expected = "89";

        // when
        final String actual = gifts.findNameByPosition(position);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
