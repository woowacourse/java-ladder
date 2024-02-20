package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputViewTest {

    @DisplayName("interface Reader로부터 받은 String을 List<String>으로 반환한다.")
    @Test
    void interface_Reader로부터_받은_String을_List으로_반환한다() {
        Assertions.assertThat(InputView.readNames(() -> "a,b,c"))
                .isEqualTo(List.of("a", "b", "c"));
    }
}