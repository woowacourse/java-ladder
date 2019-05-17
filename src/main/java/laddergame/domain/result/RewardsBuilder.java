package laddergame.domain.result;

import laddergame.ValidateBuilder;
import laddergame.domain.BuilderObject;
import laddergame.domain.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RewardsBuilder extends ValidateBuilder {
    private String names;

    public RewardsBuilder(String names) {
        this.names = names;
    }

    @Override
    public BuilderObject build() {
        validate(names);
        List<Reward> rewards = Arrays.asList(names.split(Constant.COMMA)).stream()
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
