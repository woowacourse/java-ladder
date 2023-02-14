package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"orange", "chanmin", "elephant"})
    @DisplayName("")
    void name_error_test(String errorName) {
        assertThatThrownBy(() -> new ParticipantName(errorName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    



}
