package ladder.domain.prize;

import ladder.domain.prize.exception.PrizeNameLengthException;

public class Prize {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Prize(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new PrizeNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
