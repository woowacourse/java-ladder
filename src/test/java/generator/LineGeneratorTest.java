package generator;

import domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("브릿지를 사람수 - 1개 랜덤으로 생성한다")
    void test_createBridge_randomized() {
        Line line = LineGenerator.generate(4);
        assertThat(line.getBridges()).hasSize(3);
    }
}
