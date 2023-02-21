package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<String> names, int size) {
        validate(names, size);
        List<Gift> gifts = generateGifts(names);
        this.gifts = gifts;
    }

    private void validate(List<String> names, int size) {
        if (isNotEqualsSize(names, size)) {
            throw new IllegalArgumentException("상품의 수는 참여한 플레이어의 수와 같아야 합니다.");
        }
    }

    private boolean isNotEqualsSize(List<String> names, int size) {
        return names.size() != size;
    }

    private List<Gift> generateGifts(List<String> names) {
        return names.stream()
                .map(Gift::new)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return gifts.stream()
                .map(Gift::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
