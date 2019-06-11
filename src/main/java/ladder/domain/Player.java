package ladder.domain;

import java.util.Objects;

import ladder.view.OutputView;
import org.apache.commons.lang3.StringUtils;

public class Player {
	private String playerName;

	public Player(String playerName) {
		validateNameLength(playerName);
		validateWordAllInPlayerName(playerName);
		validateNameEmpty(playerName);
		this.playerName = playerName;
	}

	private void validateNameLength(String playerName) {
		if (playerName.length() > 5) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	private void validateWordAllInPlayerName(String playerName) {
		if (playerName.equals(OutputView.PRINT_ALL_PLAYER)) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_NAME_ALL.getOutputMessage());
		}
	}

	private void validateNameEmpty(String playerName) {
		if (StringUtils.isBlank(playerName)) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_NAME_AND_REWARD_NAME.getOutputMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Player)) {
			return false;
		}
		Player player = (Player) o;
		return Objects.equals(playerName, player.playerName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerName);
	}

	@Override
	public String toString() {
		return this.playerName;
	}
}
