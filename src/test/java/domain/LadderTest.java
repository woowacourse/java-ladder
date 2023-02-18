package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사다리는 ")
class LadderTest {
	@DisplayName("1 이상 100 이하의 높이만 가능하다")
	@ParameterizedTest
	@ValueSource(ints = {1, 50, 100})
	void height1_100(int height) {
		Ladder ladder = initLadder(height, 5);

		assertThat(ladder.getHeight()).isBetween(1, 100);
	}

	@DisplayName("1 이상 100 이하의 높이가 아니면 예외가 발생한다")
	@ParameterizedTest
	@ValueSource(ints = {-2, 101})
	void heightNot1_100(int height) {
		assertThatThrownBy(() -> Ladder.from(height, 5))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 높이는 1부터 100까지만 가능합니다");
	}

	@DisplayName("참여자수 - 1 만큼의 열을 가진다")
	@Test
	void columnSizeParticipantsMinusOne() {
		int participantSize = 5;
		Ladder ladder = initLadder(4, participantSize);

		assertThat(ladder.getColumnSize()).isEqualTo(participantSize - 1);
	}

	@DisplayName("발판은 연속될 수 없다")
	@Test
	void stoolNotContinuous() {
		Ladder ladder = initLadder(4, 5);

		for (Level level : ladder.getLadder())
			for (int i = 0; i < level.size() - 1; i++)
				if (level.isStoolExist(i) && level.isStoolExist(i + 1))
					fail("발판은 연속될 수 없다");
	}

	@DisplayName("한 라인에는 반드시 하나의 발판이 있어야 한다")
	@Test
	void lineMustHaveStool() {
		Ladder ladder = initLadder(4, 6);

		assertThat(ladder.getLadder()).allMatch(level -> level.countStools() > 0);
	}

	private static Ladder initLadder(int height, int participantSize) {
		return Ladder.from(height, participantSize);
	}
}
