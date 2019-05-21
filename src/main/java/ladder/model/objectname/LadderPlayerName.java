package ladder.model.objectname;

import ladder.constant.MessageConstant;

public class LadderPlayerName extends LadderObjectName {
    public static final int MAX_LENGTH_OF_PLAYER_NAME = 5;

    public LadderPlayerName(String name) {
        super(name);
        checkMaxLenOfPlayerName(name);
    }

    private void checkMaxLenOfPlayerName(String name) {
        if (name.length() > MAX_LENGTH_OF_PLAYER_NAME) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EXCESS_PLAYER_NAME_LENGTH);
        }
    }
}
