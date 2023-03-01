package ladder.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrintCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "123", "ffff", "", " "})
    @DisplayName("PRINT_ONE 반환 테스트")
    void printOneTest(String value) {
        assertThat(PrintCommand.of(value)).isEqualTo(PrintCommand.PRINT_ONE);
    }

    @Test
    @DisplayName("PRINT_ALL 반환 테스트")
    void printAllTest() {
        assertThat(PrintCommand.of("all")).isEqualTo(PrintCommand.PRINT_ALL);
    }
}
