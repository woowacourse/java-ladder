package domain.prize;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.player.Player;

class PrizesTest {

	Prizes prizes;

	@BeforeEach
	void setUP() {
		prizes = new Prizes(List.of(
			new Prize("a"),
			new Prize("b"),
			new Prize("c")
		));
	}

	@Test
	@DisplayName("올바른 플레이어의 위치값에 대해 상품 이름을 반환한다.")
	void getPlayersPrizeNameWithValidPosition() {
		// given
		Player player = new Player("A", 0);

		// when
		String expected = "a";
		String actual = prizes.getPlayersPrizeName(player.getPosition());

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	@DisplayName("플레이어의 위치가 범위를 초과하면 예외가 발생된다.")
	void getPlayersPrizeNameWithInvalidPosition(int position) {
		assertThatThrownBy(() -> prizes.getPlayersPrizeName(position))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
