package laddergame.domain.reward;

import laddergame.BuilderObject;
import laddergame.ValidateBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RewardsBuilder extends ValidateBuilder {
    private final String names;

    public RewardsBuilder(final String names) {
        this.names = names;
    }

    @Override
    public BuilderObject createElement() {
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
        if (!(o instanceof RewardsBuilder)) return false;
        RewardsBuilder that = (RewardsBuilder) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
