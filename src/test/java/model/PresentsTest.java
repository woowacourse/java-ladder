package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PresentsTest {

    @Test
    @DisplayName("상품의 갯수는 사람 이름수와 같아야 합니다.")
    void createPresents() {
        List<String> personNames = List.of("pobi", "honux", "crong", "jk");
        List<String> presentNames = List.of("꽝", "5000", "꽝", "3000");

        assertThatCode(() -> {
            Presents presents = Presents.from(presentNames, personNames.size());
        });
    }

    @ParameterizedTest(name = "상품의 갯수와 사람 이름수가 다르면 예외가 발생합니다.")
    @ValueSource(ints = {3, 5})
    void createPresentsThrowExceptionWhenInvalidPresentNamesCount(int personCount) {
        List<String> presentNames = List.of("꽝", "5000", "꽝", "3000");
        assertThatThrownBy(() ->  Presents.from(presentNames, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품의 갯수는 사람 이름수와 같아야 합니다.");
    }

}