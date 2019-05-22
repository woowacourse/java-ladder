package laddergame.domain.result;

public class GameResultFormat {
	private final String people;
	private final String reward;

	private GameResultFormat(final String people, final String reward) {
		this.people = people;
		this.reward = reward;
	}

	public static GameResultFormat of(final String people, final String reward) {
		return new GameResultFormat(people, reward);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(people);
		stringBuilder.append("\t : \t");
		stringBuilder.append(reward);
		return stringBuilder.toString();
	}
}
