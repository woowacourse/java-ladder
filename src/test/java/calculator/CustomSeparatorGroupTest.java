package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorGroupTest {

    private CustomSeparatorGroup customSeparatorGroup;

    @BeforeEach
    void setUp() {
        customSeparatorGroup = new CustomSeparatorGroup();
    }

    @Test
    void 생성자() {
        assertThat(customSeparatorGroup.getCustomSeparators()).contains(new CustomSeparator(","), new CustomSeparator(":"));
    }

    @Test
    void 구분자_결합() {
        assertThat(customSeparatorGroup.combineSeparatorToRegex()).isEqualTo(":|,");
    }

    @Test
    void 구분자_그룹_추가() {
        customSeparatorGroup.addCustomSeparator(new CustomSeparator(";"));
        assertThat(customSeparatorGroup.getCustomSeparators()).contains(new CustomSeparator(":"), new CustomSeparator(","), new CustomSeparator(";"));
    }

    @Test
    void 구분자_그룹_추가_후_결합() {
        customSeparatorGroup.addCustomSeparator(new CustomSeparator(";"));
        assertThat(customSeparatorGroup.combineSeparatorToRegex()).isEqualTo(":|;|,");
    }
}
