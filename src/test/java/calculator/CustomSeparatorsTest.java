package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorsTest {

    private CustomSeparators customSeparators;

    @BeforeEach
    void setUp() {
        customSeparators = new CustomSeparators();
    }

    @Test
    void 생성자() {
        assertThat(customSeparators.getCustomSeparators()).contains(new CustomSeparator(","), new CustomSeparator(":"));
    }

    @Test
    void 구분자_결합() {
        assertThat(customSeparators.combineSeparatorToRegex()).isEqualTo(":|,");
    }

    @Test
    void 구분자_그룹_추가() {
        customSeparators.addCustomSeparator(new CustomSeparator(";;;"));
        assertThat(customSeparators.getCustomSeparators()).contains(new CustomSeparator(":"), new CustomSeparator(","), new CustomSeparator(";;;"));
    }

    @Test
    void 구분자_그룹_추가_후_결합() {
        customSeparators.addCustomSeparator(new CustomSeparator(";"));
        assertThat(customSeparators.combineSeparatorToRegex()).isEqualTo(":|;|,");
    }
}
