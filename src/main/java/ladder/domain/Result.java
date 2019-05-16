package ladder.domain;

public class Result {
	private Player player;
	private String reward;

	public Result(Player player, String reward) {
		this.player = player;
		this.reward = reward;
	}

	public Player getPlayer() {
		return player;
	}

	public String getReward() {
		return reward;
	}
}
