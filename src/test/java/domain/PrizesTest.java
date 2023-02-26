package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Prizes 는")
public class PrizesTest {

    final Prize borderPrize = new Prize("보더");
    final List<Prize> prizeList = List.of(borderPrize, new Prize("콜리"));


    @Test
    void Names_와_Prize_List_를_받아_생성된다() {
        assertDoesNotThrow(() -> new Prizes(prizeList, new Names(List.of(new Name("가비"), new Name("찰리")))));
    }

    @ParameterizedTest(name = "Names 와 크기가 다르면 예외가 발생한다")
    @MethodSource("failResultPrizes")
    void Names_와_크기가_다르면_예외가_발생한다(List<Prize> prizes) {
        Names names = new Names(List.of(new Name("가비"), new Name("찰리"), new Name("구구")));

        assertThatThrownBy(() -> new Prizes(prizes, names)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> failResultPrizes() {
        return Stream.of(
                Arguments.of(List.of(new Prize("이글을"), new Prize("본다면"))),
                Arguments.of(List.of(new Prize("당근을"), new Prize("흔들어"), new Prize("주세요"), new Prize("🥕🥕")))
        );
    }

    @Test
    void Prize_의_요소들을_알_수_있다() {
        List<Prize> testPrizes = List.of(new Prize("1등"), new Prize("2등"));
        Prizes prizes = new Prizes(testPrizes, new Names(List.of(new Name("찰리"), new Name("가비"))));

        assertThat(prizes.getPrizes()).isEqualTo(testPrizes);
    }

    @Test
    void Prize_의_순서를_알_수_있다() {
        final Prizes prizes = new Prizes(prizeList, new Names(List.of(new Name("가비"), new Name("찰리"))));

        assertThat(prizes.getPrizeByIndex(0)).isEqualTo(borderPrize);
    }
}
