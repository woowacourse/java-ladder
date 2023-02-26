package laddergame.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.exception.IllegalIndexException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class IndexValidatorTest {

    @Test
    @DisplayName("인덱스가 범위를 넘어갈 경우 예외와 의도한 메시지를 던진다.")
    void should_ThrowException_When_IndexOutOfBounds2() {
        String exceptionMessage = "범위를 벗어났습니다. (size: 3, index: 3)";

        List<Integer> target = new ArrayList<>(List.of(1, 2, 3));
        
        assertThatThrownBy(() -> IndexValidator.validateBounds(target, 3))
                .isInstanceOf(IllegalIndexException.class)
                .hasMessageContaining(exceptionMessage);
    }
}
