package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Prize 는")
public class PrizeTest {

    @ParameterizedTest(name = "생성 시 파라미터로 받은 이름을 값으로 가진다 name : {0}")
    @ValueSource(strings = {"1등", "꽝", "2등", "꼴지"})
    void 생성_시_받은_파라미터를_값으로_가진다(String input) {
        Prize prize = new Prize(input);
        assertThat(prize.getValue()).isEqualTo(input);
    }
}
