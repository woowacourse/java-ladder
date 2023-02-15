package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @Test
    @DisplayName("Height 수 만큼 Point 생성")
    void createPointSuccess() {
        Line line = Line.fromHeight(new Height(30));

        assertThat(line.getPoints())
                .hasSize(30);
    }

    @DisplayName("지정한 위치에 가로라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void createHorizontalLineAtSuccess(int input) {
        Line line = Line.fromHeight(new Height(5));

        line.createHorizontalLineAt(input);

        assertThat(line.getPoints().get(input - 1)).isTrue();
    }
}
