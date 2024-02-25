package view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClimbResultPrinterTest {

    @Test
    @DisplayName("사다리 타기 출력 문자열 생성")
    void of() {
        List<String> actualResults = ClimbResultPrinter.of(List.of("nameA", "nameB"), List.of("A", "B"));
        List<String> expectedResults = List.of("nameA : A", "nameB : B");
        Assertions.assertThat(actualResults)
                .containsExactlyElementsOf(expectedResults);
    }
}
