package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.LineStatus;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineMakerTest {

    private List<LineStatus> line;

    @BeforeEach
    void init() {
        line = new ArrayList<>();
    }

    @Test
    @DisplayName("라인의 첫번째 Status 추가")
    void makeFirstLineStatus() {
        LineMaker.makeFirstLineStatus(new ExistLineGenerator(), line);

        assertThat(line.get(0)).isEqualTo(LineStatus.EXIST);
    }

    @Test
    @DisplayName("라인의 첫번째 이후의 Status 추가")
    void makeElseLineStatus() {
        LineMaker.makeFirstLineStatus(new ExistLineGenerator(), line);
        LineMaker.makeElseLineStatus(new ExistLineGenerator(), line, 3);

        assertAll(
                () -> assertThat(line.get(1)).isEqualTo(LineStatus.EXIST),
                () -> assertThat(line.get(2)).isEqualTo(LineStatus.EXIST)
        );
    }

    @Test
    @DisplayName("이전 Status가 true이면 이후 Status는 무조건 false이다.")
    void makeRandomLine() {
        line.add(LineStatus.EXIST);

        LineGenerator lineGenerator = new RandomLineGenerator();
        assertThat(lineGenerator.generate(line.get(0).getStatus())).isFalse();
    }
}
