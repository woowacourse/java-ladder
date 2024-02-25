package generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.FloorConnectionStatus;

class LadderFloorGeneratorTest {

	@Test
	@DisplayName("연속해서 연결되지 않는 한 층을 생성한다.")
	void generateFalseAfterTrueTest() {
		// given
		BooleanSupplier trueSupplier = () -> true;
		LadderFloorGenerator ladderGenerator = new LadderFloorGenerator(trueSupplier);
		// when
		List<FloorConnectionStatus> actual = ladderGenerator.generate(5);
		List<FloorConnectionStatus> expected = List.of(
			FloorConnectionStatus.CONNECTED_TO_RIGHT,
			FloorConnectionStatus.CONNECTED_TO_LEFT,
			FloorConnectionStatus.CONNECTED_TO_RIGHT,
			FloorConnectionStatus.CONNECTED_TO_LEFT,
			FloorConnectionStatus.NOT_CONNECTED
		);
		// then
		assertThat(actual).containsExactlyElementsOf(expected);
	}
}
