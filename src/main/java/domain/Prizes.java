package domain;

import java.util.List;

public class Prizes {

	private final List<Prize> prizes;

	public Prizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

	public static Prizes fromNames(List<String> prizeNames) {
		List<Prize> prizes = prizeNames.stream()
			.map(Prize::fromName)
			.toList();

		return new Prizes(prizes);
	}

	public Prize getPlayersPrize(int playersPosition) {
		return prizes.get(playersPosition);
	}

	public List<String> getPrizeNames() {
		return prizes.stream()
			.map(Prize::getName)
			.toList();
	}
}