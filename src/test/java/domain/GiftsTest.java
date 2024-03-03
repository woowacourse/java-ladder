package domain;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftsTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("상품 수가 너무 적거나 너무 많은지 확인")
    void validateGiftsCount(int giftsCount) {
        List<String> giftNames = IntStream.rangeClosed(1, giftsCount)
                .mapToObj("a%d"::formatted)
                .toList();

        Assertions.assertThatThrownBy(() -> Gifts.of(giftNames))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("상품은 2개 이상 10개 이하여야 합니다.");
    }

}
