
package domain.player;

import common.exception.model.NotFoundException;
import common.exception.model.ValidationException;

import java.util.List;

public class PlayerNames {
    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";
    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;

    private final List<PlayerName> values;

    public PlayerNames(List<PlayerName> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    private void validate(List<PlayerName> playerNames) {
        validateDuplication(playerNames);
        validateRange(playerNames);
    }

    private void validateRange(List<PlayerName> playerNames) {
        if (playerNames.size() < PLAYER_NAMES_MIN_RANGE || playerNames.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new ValidationException(PLAYER_NAMES_RANGE);
        }
    }

    private void validateDuplication(List<PlayerName> playerNames) {
        int playerCount = playerNames.size();
        long distinctCount = playerNames.stream().map(PlayerName::getName).distinct().count();

        if (playerCount != distinctCount) {
            throw new ValidationException(PLAYER_NAMES_DUPLICATION);
        }
    }

    public int getCount() {
        return values.size();
    }

    public String getNameOfIndex(int index) {
        return values.get(index).getName();
    }

    public int getIndexOfName(String name) {
        for (int i = 0; i < values.size(); i++) {
            if(values.get(i).getName().equals(name)) {
                return i;
            }
        }
        throw new NotFoundException("존재하지 않는 참가자 이름입니다");
    }
}
