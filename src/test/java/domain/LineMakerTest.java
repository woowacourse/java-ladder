package domain;

import static org.assertj.core.api.Assertions.assertThat;

import generator.ExistLineGenerator;
import generator.LineGenerator;
import generator.NonExistLineGenerator;
import generator.RandomLineGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineMakerTest {

    @Test
    @DisplayName("LineMaker는 numberOfLine 수와 같은 개수의 LineStatus를 만들어 반환한다.")
    void makeLineStatus() {
        LineMaker lineMaker = new LineMaker(new RandomLineGenerator());
        int numberOfLine = 3;

        List<LineStatus> lineStatuses = lineMaker.makeLineStatus(numberOfLine);
        assertThat(lineStatuses.size()).isEqualTo(numberOfLine);
    }

    @Test
    @DisplayName("이전 Status가 true이면 이후 Status는 무조건 false이다.")
    void makeRandomLine() {
        List<LineStatus> lineStatuses = new ArrayList<>();
        lineStatuses.add(LineStatus.EXIST);

        LineGenerator lineGenerator = new RandomLineGenerator();
        assertThat(lineGenerator.generate(lineStatuses.get(0).getStatus())).isFalse();
    }

    @Test
    @DisplayName("다리가 존재하는 Line생성")
    void makeExistLine() {
        LineMaker lineMaker = new LineMaker(new ExistLineGenerator());
        int numberOfLine = 1;
        List<LineStatus> lineStatuses = lineMaker.makeLineStatus(numberOfLine);

        assertThat(lineStatuses.get(0)).isEqualTo(LineStatus.EXIST);
    }

    @Test
    @DisplayName("다리가 존재하지 않는 Line생성")
    void makeNonExistLine() {
        LineMaker lineMaker = new LineMaker(new NonExistLineGenerator());
        int numberOfLine = 1;
        List<LineStatus> lineStatuses = lineMaker.makeLineStatus(numberOfLine);

        assertThat(lineStatuses.get(0)).isEqualTo(LineStatus.NON_EXIST);
    }
}
