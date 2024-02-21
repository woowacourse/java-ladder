package generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderBooleanGeneratorTest {

    @Test
    @DisplayName("이전에 true가 나온 경우, false를 반환한다.")
    void generateFalseAfterTrue() {
        // given
        BooleanGenerator trueGenerator = () -> true;
        BooleanGenerator ladderGenerator = new LadderBooleanGenerator(trueGenerator);
        // when
        List<Boolean> actual = Stream.generate(ladderGenerator::generate)
                .limit(5)
                .toList();
        List<Boolean> expected = List.of(true, false, true, false, true);
        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
