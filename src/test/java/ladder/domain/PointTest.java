package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
	private Point point;

	@BeforeEach
	void init() {
		point = Point.first();
	}

	@Test
	void 왼쪽_포인트와_오른쪽_포인트가_true인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> point.valueOf(true, true));
	}

	@Test
	void 첫번째_위치의_포인트일때_왼쪽_포인트_확인() {
		assertThat(point.canGoLeft()).isEqualTo(false);
	}

	@Test
	void 마지막_위치의_포인트일때_오른쪽_포인트_확인() {
		assertThat(point.last().canGoRight()).isEqualTo(false);
	}

	@Test
	void 이전_위치_값이_true_일때_다음_오른쪽_위치_값_false_반환() {

		assertThat(point.valueOf(false, true).next().canGoRight()).isEqualTo(false);
	}

	@Test
	void 왼쪽_이동_확인() {
		assertThat(point.valueOf(true, false).move()).isEqualTo(Direction.LEFT);
	}

	@Test
	void 오른쪽_이동_확인() {
		assertThat(point.valueOf(false, true).move()).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 정지_확인() {
		assertThat(point.last().move()).isEqualTo(Direction.STOP);
	}
}
