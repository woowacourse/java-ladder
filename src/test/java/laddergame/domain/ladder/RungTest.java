package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RungTest {

    @ParameterizedTest
    @ValueSource(booleans = {true})
    @DisplayName("true가 입력되면 존재하는지 확인한다.")
    void exists_if_input_is_true(final boolean canMakeRung) {
        // given
        Rung rung = Rung.create(canMakeRung);

        // when
        boolean actualValue = rung.exists();

        // then
        assertThat(actualValue).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {false})
    @DisplayName("false가 입력되면 존재하지 않는지 확인한다.")
    void does_not_exist_if_input_is_false(final boolean canMakeRung) {
        // given
        Rung rung = Rung.create(canMakeRung);

        // when
        boolean actualValue = rung.exists();

        // then
        assertThat(actualValue).isFalse();
    }
}
