package domain.reward;

import domain.common.Name;

public record PlayerResult(Name name, Result result) {
    public String nameToString() {
        return name.nameToString();
    }

    public String rewardToString() {
        return result.resultToString();
    }
}
