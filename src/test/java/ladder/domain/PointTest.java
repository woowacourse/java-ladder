package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
	public static final Point CAN_MOVE_LEFT_POINT = new Point(true, false);
	public static final Point CAN_MOVE_RIGHT_POINT = new Point(false, true);
	public static final Point STOP_POINT = new Point(false, false);

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
		assertThat(CAN_MOVE_LEFT_POINT.last().canGoRight()).isEqualTo(false);
	}

	@Test
	void 이전_위치_값이_true_일때_다음_오른쪽_위치_값_false_반환() {
		Point point = CAN_MOVE_RIGHT_POINT.next();
		assertThat(point.canGoRight()).isEqualTo(false);
	}

	@Test
	void 왼쪽_이동_확인() {
		assertThat(CAN_MOVE_LEFT_POINT.move()).isEqualTo(Direction.LEFT);
	}

	@Test
	void 오른쪽_이동_확인() {
		assertThat(CAN_MOVE_RIGHT_POINT.move()).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 정지_확인() {
		assertThat(STOP_POINT.move()).isEqualTo(Direction.STOP);
	}
}
