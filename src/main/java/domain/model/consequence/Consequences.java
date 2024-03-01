package domain.model.consequence;

import java.util.List;

public class Consequences {
    private final List<Consequence> consequences;

    public Consequences(List<String> consequences, int numberOfPeople) {
        validateSize(consequences, numberOfPeople);
        this.consequences = consequences.stream()
                .map(Consequence::new)
                .toList();
    }

    private void validateSize(List<String> consequences, int numberOfPeople) {
        if (consequences.size() != numberOfPeople) {
            throw new IllegalArgumentException("결과는 사람 수와 일치해야 합니다.");
        }
    }

    public Consequence getConsequenceByOrder(int order) {
        return consequences.get(order);
    }

    public List<Consequence> getConsequences() {
        return consequences;
    }
}
