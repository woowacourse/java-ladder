package generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Bar;

class LadderFloorGeneratorTest {

	@Test
	@DisplayName("연속해서 연결되지 않는 한 층을 생성한다.")
	void generateFalseAfterTrueTest() {
		// given
		BooleanSupplier trueSupplier = () -> true;
		LadderFloorGenerator ladderGenerator = new LadderFloorGenerator(trueSupplier);
		// when
		List<Bar> actual = ladderGenerator.generate(5);
		List<Bar> expected = List.of(
			Bar.CONNECTED_TO_RIGHT,
			Bar.CONNECTED_TO_LEFT,
			Bar.CONNECTED_TO_RIGHT,
			Bar.CONNECTED_TO_LEFT,
			Bar.NOT_CONNECTED
		);
		// then
		assertThat(actual).containsExactlyElementsOf(expected);
	}
}