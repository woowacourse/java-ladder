import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("사다리의 열은 참가자의 수보다 하나 적다.")
    @Test
    void lengthOfLine() {
        int participantSize = 5;
        Line line = new Line(participantSize);
        Assertions.assertThat(line.size()).isEqualTo(participantSize - 1);
    }
}
