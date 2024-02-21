package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @DisplayName(",로 구분하여 이름을 입력하면 List<String>로 반환한다.")
    @Test
    void parseNamesWithDelimiter() {
        List<String> names = InputView.readNames(() -> "a,b,c");
        assertThat(names).containsExactly("a", "b", "c");
    }

}
