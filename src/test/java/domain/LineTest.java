package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("Height 수 만큼 Point 생성")
    void createPointSuccess() {
        Line line = Line.fromHeight(new Height(30));

        assertThat(line.getPoints())
                .hasSize(30);
    }
}
