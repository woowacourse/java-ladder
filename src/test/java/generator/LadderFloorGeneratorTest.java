package generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFloorGeneratorTest {

	@Test
	@DisplayName("항상 true를 반환하는 generator를 가지는 경우, 이전에 true가 나온 경우, false를 반환한다.")
	void generateFalseAfterTrueTest() {
		// given
		BooleanSupplier trueSupplier = () -> true;
		LadderFloorGenerator ladderGenerator = new LadderFloorGenerator(trueSupplier);
		// when
		List<Boolean> actual = ladderGenerator.generate(5);
		List<Boolean> expected = List.of(true, false, true, false, true);
		// then
		assertThat(actual).containsExactlyElementsOf(expected);
	}
}
