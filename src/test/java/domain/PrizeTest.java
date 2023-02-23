package domain;

import exception.InvalidPrizeNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PrizeTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "  "})
    void 상품명은_빈칸이거나_null_값이_들어오면_에러를_발생시킨다(String prize) {
        //when + then
        Assertions.assertThatThrownBy(() -> new Prize(prize))
            .isInstanceOf(InvalidPrizeNameException.class);
    }

}
