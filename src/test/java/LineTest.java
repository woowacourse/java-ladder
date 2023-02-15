import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("참가자수-1만큼 status 생성")
    void makeLine() {
        int numberOfLine = 3;
        Line line = new Line(numberOfLine, new RandomLineGenerator());
        assertThat(line.getLine().size()).isEqualTo(numberOfLine);
    }

    @Test
    @DisplayName("다리가 존재하는 Line생성")
    void makeExistLine() {
        int numberOfLine = 3;
        Line line = new Line(numberOfLine, new ExistLineGenerator());

        assertAll(
                () -> assertThat(line.getLine().get(0)).isEqualTo(LineStatus.EXIST),
                () -> assertThat(line.getLine().get(1)).isEqualTo(LineStatus.EXIST),
                () -> assertThat(line.getLine().get(2)).isEqualTo(LineStatus.EXIST)
        );
    }

    @Test
    @DisplayName("다리가 존재하지 않는 Line생성")
    void makeNonExistLine() {
        int numberOfLine = 3;
        Line line = new Line(numberOfLine, new NonExistLineGenerator());

        assertAll(
                () -> assertThat(line.getLine().get(0)).isEqualTo(LineStatus.NON_EXIST),
                () -> assertThat(line.getLine().get(1)).isEqualTo(LineStatus.NON_EXIST),
                () -> assertThat(line.getLine().get(2)).isEqualTo(LineStatus.NON_EXIST)
        );
    }
}
