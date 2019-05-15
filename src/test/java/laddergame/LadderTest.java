package laddergame;

import laddergame.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {

	@Test
	public void 레더_테스트_사다리의_너비가_1일때() {
		Ladder ladder = new Ladder(1, 1);
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ladder.connect(1, 1);
		});
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ladder.isLinked(1, 1);
		});
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ladder.isLinked(1, 1);
		});
	}

	@Test
	public void 레더_테스트2() {
		Ladder ladder = new Ladder(1, 2);
		ladder.connect(1, 1);
		assertThat(ladder.isLinked(1, 1)).isTrue();
	}

	@Test
	public void 레더_테스트3() {
		Ladder ladder = new Ladder(2, 2);
		ladder.connect(1, 1);
		ladder.connect(2, 1);
		assertThat(ladder.isLinked(1, 1)).isTrue();
		assertThat(ladder.isLinked(2, 1)).isTrue();
	}

	@Test
	public void 레더_테스트4() {
		Ladder ladder = new Ladder(3, 3);
		ladder.connect(1, 1);
		ladder.connect(2, 1);
		ladder.connect(3, 2);
		assertThat(ladder.isLinked(1, 1)).isTrue();
		assertThat(ladder.isLinked(2, 1)).isTrue();
		assertThat(ladder.isLinked(3, 2)).isTrue();
	}

	@Test
	public void 사다리에서_이웃한_연결로를_추가할_때_예외발생하는지_검사() {
		Ladder ladder = new Ladder(4, 4);
		ladder.connect(1,2);
		ladder.connect(2,1 );

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ladder.connect(1, 1);
			ladder.connect(1, 3);
		});

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			ladder.connect(2, 2);
		});
	}
}
