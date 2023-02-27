package ladder.domain.ladder;

import ladder.domain.rule.StoolGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LineTest {

    @Test
    @DisplayName("라인에 연속해서 발판이 놓인다면 다시 블록을 놓는다.")
    void 라인이_재생성되는지_테스트() {
        List<Stool> stools = newArrayList(Stool.EXIST, Stool.EXIST);
        StoolGenerator stoolGenerator = new TestStoolGenerator(new ArrayList<>(stools));
        int playerNumber = stools.size() + 1;

        assertThat(new Line(playerNumber, stoolGenerator).getStools())
                .isNotEqualTo(stools);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("<플레이어수 - 1>만큼의 발판이 생성된다.")
    void 올바른_개수의_발판이_생성되는지_확인(List<Stool> stools, int playerNumber) {
        StoolGenerator stoolGenerator = new TestStoolGenerator(new ArrayList<>(stools));

        assertThat(new Line(playerNumber, stoolGenerator).getStools().size())
                .isEqualTo(playerNumber - 1);
    }

    private List<Arguments> parameterProvider() {
        return List.of(
                Arguments.of(List.of(Stool.EXIST), 2),
                Arguments.of(List.of(Stool.EXIST, Stool.EXIST), 3)
        );
    }

    @Test
    void 발판이_있는경우_따라_잘_이동하는지_확인() {
        List<Stool> intendedStools = List.of(Stool.EXIST, Stool.EXIST);
        Line line = new Line(3, new TestStoolGenerator(new ArrayList<>(intendedStools)));

        assertThat(line.getWentDownLocation(0)).isEqualTo(1);
    }

    @Test
    void 발판이_없는경우_잘_이동하는지_확인() {
        List<Stool> intendedStools = List.of(Stool.EMPTY, Stool.EXIST);
        Line line = new Line(3, new TestStoolGenerator(new ArrayList<>(intendedStools)));

        assertThat(line.getWentDownLocation(0)).isEqualTo(0);
    }
}
