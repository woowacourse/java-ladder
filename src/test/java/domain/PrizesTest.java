package domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PrizesTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructorSuccessTest() {
        Names names = new Names(List.of("타칸", "짱수", "조앤", "파랑"));
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Prizes(prizes, names));
    }

    @DisplayName("상품목록 객체는 최소 2개 이상이여야 한다.")
    @ParameterizedTest
    @MethodSource("constructorFailWithLessThen2TestProvider")
    void constructorFailWithLessThen2Test(List<String> prizes, Names names) {

        Assertions.assertThatThrownBy(() -> new Prizes(prizes, names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> constructorFailWithLessThen2TestProvider() {
        return Stream.of(
                Arguments.of(List.of(), new Names(List.of("타칸", "짱수")),
                Arguments.of(List.of("5000"), new Names(List.of("타칸", "짱수"))))
        );
    }

    @DisplayName("상품목록 객체의 개수는 사람 수와 동일해야한다.")
    @ParameterizedTest
    @MethodSource("constructorFailWithMissMatchCountTestProvider")
    void constructorFailWithMissMatchCountTest(List<String> prizes, Names names) {

        Assertions.assertThatThrownBy(() -> new Prizes(prizes, names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> constructorFailWithMissMatchCountTestProvider() {
        return Stream.of(
                Arguments.of(List.of("꽝", "5000", "꽝"), new Names(List.of("타칸", "짱수", "조앤", "파랑")),
                Arguments.of(List.of("꽝", "5000", "꽝"), new Names(List.of("타칸", "짱수"))))
        );
    }
}
