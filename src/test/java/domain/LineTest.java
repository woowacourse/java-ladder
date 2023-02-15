package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    @DisplayName("한 라인에 사람 수 만큼 칸이 생성되는가")
    void createSpaceTest(int personCount) {
        //given
        //when
        Line line = new Line(personCount);

        //then
        assertThat(line.getBridges().size()).isEqualTo(personCount - 1);
    }

}