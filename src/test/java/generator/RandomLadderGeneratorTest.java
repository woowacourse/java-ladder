package generator;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.ladder.Bar;
import domain.ladder.Floor;
import domain.ladder.Ladder;

class RandomLadderGeneratorTest {

	@Test
	@DisplayName("연속된 연결이 없는 층으로 이루어진 사다리를 생성한다.")
	void generateFalseAfterTrueTest() {
		// given
		RandomLadderGenerator ladderGene = createTestLadderGenerator();

		// when
		Ladder actual = ladderGene.generate(2, 3);
		Ladder expected = new Ladder(List.of(
			new Floor(List.of(Bar.CONNECTED_TO_RIGHT, Bar.CONNECTED_TO_LEFT, Bar.NOT_CONNECTED)),
			new Floor(List.of(Bar.NOT_CONNECTED, Bar.CONNECTED_TO_RIGHT, Bar.CONNECTED_TO_LEFT))
		));

		// then
		assertThat(actual.createLadderConnectionStatus()).isEqualTo(expected.createLadderConnectionStatus());
	}

	/**
	 다음과 같은 사다리를 만들도록 설정한다.
	 |-----|     |
	 |     |-----|
	 */
	private RandomLadderGenerator createTestLadderGenerator() {
		Iterator<Boolean> iterator = List.of(true, false, true).iterator();
		Random random = new Random() {
			@Override
			public boolean nextBoolean() {
				return iterator.next();
			}
		};

		return new RandomLadderGenerator(random);
	}
}
