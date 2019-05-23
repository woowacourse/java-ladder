package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
	@Test
	void 왼쪽_포인트와_오른쪽_포인트가_true인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Point(true, true));
	}

	@Test
	void 첫번째_위치의_포인트일때_왼쪽_포인트_확인() {
		Point point = Point.first();
		assertThat(point.canGoLeft()).isEqualTo(false);
	}

	@Test
	void 마지막_위치의_포인트일때_오른쪽_포인트_확인() {
		Point point = Point.last(true);
		assertThat(point.canGoRight()).isEqualTo(false);
	}

	@Test
	void 이전_위치_값이_true_일때_다음_오른쪽_위치_값_false_반환() {
		Point point = new Point(false, true).next();
		assertThat(point.canGoRight()).isEqualTo(false);
	}

	@Test
	void 왼쪽_이동_확인() {
		assertThat(new Point(true, false).move()).isEqualTo(-1);
	}

	@Test
	void 오른쪽_이동_확인() {
		assertThat(new Point(false, true).move()).isEqualTo(1);
	}

	@Test
	void 정지_확인() {
		assertThat(new Point(false, false).move()).isEqualTo(0);
	}
}
