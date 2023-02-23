package domain;

import domain.Ladder.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderWidthTest {

	@Test
	@DisplayName("정상 사다리너비 테스트")
	public void validLadderWidthTest(){
		int number = 5;
		LadderWidth width = LadderWidth.from(number);
		assertThat(width.getWidth()).isEqualTo(5);
	}

	@Test
	@DisplayName("비정상 사다리너비 테스트 - 0일때")
	public void invalidLadderWidthTest(){
		int number = 0;
		assertThatThrownBy(() -> LadderWidth.from(number)).isInstanceOf(IllegalArgumentException.class);
	}
}
