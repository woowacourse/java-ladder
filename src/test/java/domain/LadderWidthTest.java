package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

class LadderWidthTest {

	@Test
	@DisplayName("정상 사다리너비 테스트")
	public void validLadderWidthTest(){
		int number = 5;
		LadderWidth width = new LadderWidth(number);
		assertThat(width.getWidth()).isEqualTo(5);
	}

	@Test
	@DisplayName("비정상 사다리너비 테스트 - 0일때")
	public void invalidLadderWidthTest(){
		int number = 0;
		assertThatThrownBy(()->new LadderWidth(number)).isInstanceOf(IllegalArgumentException.class);
	}
}
