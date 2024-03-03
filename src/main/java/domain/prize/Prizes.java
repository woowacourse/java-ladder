package domain.prize;

import java.util.List;

public class Prizes {

	private final List<Prize> prizes;

	public Prizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public String getPlayersPrizeName(int playerFinalPosition) {
		validatePosition(playerFinalPosition);
		Prize prize = prizes.get(playerFinalPosition);
		return prize.getName();
	}

	private void validatePosition(int playerFinalPosition) {
		if (playerFinalPosition < 0 || playerFinalPosition >= prizes.size()) {
			throw new IllegalArgumentException("올바른 위치값이 아닙니다.");
		}
	}

	public List<String> getNames() {
		return prizes.stream()
			.map(Prize::getName)
			.toList();
	}
}
