package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import ladder.domain.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultViewTest {
    private final ResultView resultView = new ResultView();

    static Stream<Arguments> 사다리_가로줄_출력_데이터() {
        return Stream.of(
                Arguments.of(List.of(Step.N, Step.Y), "     |     |-----|"),
                Arguments.of(List.of(Step.N, Step.N), "     |     |     |"),
                Arguments.of(List.of(Step.Y, Step.N, Step.Y), "     |-----|     |-----|")
        );
    }

    @ParameterizedTest(name = "<List<Foothold>에 따른 사다리 가로줄 출력 성공")
    @MethodSource("사다리_가로줄_출력_데이터")
    public void 사다리_가로줄_출력(List<Step> steps, String expected) {
        assertThat(resultView.generateRow(steps)).isEqualTo(expected);
    }
}
