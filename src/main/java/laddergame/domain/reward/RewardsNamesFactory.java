package laddergame.domain.reward;

import laddergame.domain.AbstractNamesFactory;
import laddergame.NameList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RewardsNamesFactory extends AbstractNamesFactory {
	private final String names;

	public RewardsNamesFactory(final String names) {
		this.names = names;
	}

	@Override
	public NameList create() {
		validate(this.names);
		List<Reward> rewards = Arrays.asList(this.names.split(this.DELIMITER)).stream()
				.map(String::trim)
				.map(Reward::new)
				.collect(Collectors.toList());

		return new Rewards(rewards);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RewardsNamesFactory)) return false;
		RewardsNamesFactory that = (RewardsNamesFactory) o;
		return Objects.equals(names, that.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}
}
