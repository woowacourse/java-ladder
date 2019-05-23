package laddergame.domain.player;


import laddergame.domain.NameList;
import laddergame.domain.ProhibitDuplicateNamesNamesFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayersNamesFactory extends ProhibitDuplicateNamesNamesFactory {
	private final String names;

	public PlayersNamesFactory(final String names) {
		this.names = names;
	}

	@Override
	public NameList create() throws IllegalArgumentException {
		validate(names);
		List<Player> players = Arrays.asList(names.split(this.DELIMITER)).stream()
				.map(String::trim)
				.map(Player::new)
				.collect(Collectors.toList());

		checkDuplication(players);
		return new Players(players);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PlayersNamesFactory)) return false;
		PlayersNamesFactory that = (PlayersNamesFactory) o;
		return Objects.equals(names, that.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
