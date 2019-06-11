package ladder.domain.generator;

import ladder.generator.PointGenerator;
import org.junit.jupiter.api.Test;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointGeneratorTest {
	@Test
	void 첫번째_위치의_포인트일때_왼쪽_포인트_확인() {
		assertThat(PointGenerator.firstPoint().canGoLeft()).isEqualTo(false);
	}

	@Test
	void 마지막_위치의_포인트일때_오른쪽_포인트_확인() {
		assertThat(PointGenerator.lastPoint(STOP_POSITION).canGoRight()).isEqualTo(false);
		assertThat(PointGenerator.lastPoint(RIGHT_POSITION).canGoRight()).isEqualTo(false);
		assertThat(PointGenerator.lastPoint(LEFT_POSITION).canGoRight()).isEqualTo(false);
	}

	@Test
	void 현재_위치_값이_true일때_다음_위치_값_false_확인() {
		assertThat(PointGenerator.nextPoint(RIGHT_POSITION)).isEqualTo(LEFT_POSITION);
	}

	@Test
	void 현재_위치_값이_false일때_다음_왼쪽_위치_값_false_확인() {
		assertThat(PointGenerator.nextPoint(RIGHT_POSITION).canGoRight()).isEqualTo(false);
	}
}
