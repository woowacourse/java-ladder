package ladder.domain;

import org.junit.jupiter.api.Test;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
	@Test
	void 왼쪽_위치_값이_true일때_왼쪽_이동_가능_확인() {
		assertThat(LEFT_POSITION.canGoLeft()).isEqualTo(true);
	}

	@Test
	void 왼쪽_위치_값이_false일때_왼쪽_이동_가능_확인() {
		assertThat(RIGHT_POSITION.canGoLeft()).isEqualTo(false);
		assertThat(STOP_POSITION.canGoLeft()).isEqualTo(false);
	}

	@Test
	void 오른쪽_위치_값이_true일때_오른쪽_이동_가능_확인() {
		assertThat(RIGHT_POSITION.canGoRight()).isEqualTo(true);
	}

	@Test
	void 오른쪽_위치_값이_false일때_오른쪽_이동_가능_확인() {
		assertThat(LEFT_POSITION.canGoRight()).isEqualTo(false);
		assertThat(STOP_POSITION.canGoRight()).isEqualTo(false);
	}

	@Test
	void 왼쪽_이동_확인() {
		assertThat(LEFT_POSITION.move()).isEqualTo(Direction.LEFT);
	}

	@Test
	void 오른쪽_이동_확인() {
		assertThat(RIGHT_POSITION.move()).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 정지_확인() {
		assertThat(STOP_POSITION.move()).isEqualTo(Direction.STOP);
	}
}
