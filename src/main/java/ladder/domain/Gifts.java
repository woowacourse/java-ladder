package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Gifts {

    private static final String GIFT_NOT_EQUAL_PLAYER_ERROR_MESSAGE = "상품의 수는 참여한 플레이어의 수와 같아야 합니다.";

    private final List<Gift> gifts;

    public Gifts(final List<String> names, final int size) {
        validate(names, size);
        this.gifts = generateGifts(names);
    }

    private void validate(final List<String> names, final int size) {
        if (isNotEqualsSize(names, size)) {
            throw new IllegalArgumentException(GIFT_NOT_EQUAL_PLAYER_ERROR_MESSAGE);
        }
    }

    private boolean isNotEqualsSize(final List<String> names, final int size) {
        return names.size() != size;
    }

    private List<Gift> generateGifts(final List<String> names) {
        return names.stream()
                .map(Gift::new)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return gifts.stream()
                .map(Gift::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public String findNameByPosition(final int position) {
        return gifts.get(position).getName();
    }
}
