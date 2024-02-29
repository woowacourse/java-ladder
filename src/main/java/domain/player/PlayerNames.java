
package domain.player;

import common.exception.model.NotFoundException;
import common.exception.model.ValidationException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerNames {
    public static final String RANGE_ERROR_MESSAGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.RANGE_MIN, PlayerNames.RANGE_MAX);
    public static final String DUPLICATION_ERROR_MESSAGE = "참가자 이름은 중복될 수 없습니다";
    public static final String NOT_FOUND_ERROR_MESSAGE = "존재하지 않는 참가자 이름입니다";
    public static final int RANGE_MIN = 2;
    public static final int RANGE_MAX = 10;

    private final List<PlayerName> values;

    public PlayerNames(List<PlayerName> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    private void validate(List<PlayerName> playerNames) {
        validateDuplication(playerNames);
        validateRange(playerNames);
    }

    private void validateDuplication(List<PlayerName> playerNames) {
        int playerCount = playerNames.size();
        long distinctCount = playerNames.stream().map(PlayerName::getValue).distinct().count();

        if (playerCount != distinctCount) {
            throw new ValidationException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<PlayerName> playerNames) {
        if (playerNames.size() < RANGE_MIN || playerNames.size() > RANGE_MAX) {
            throw new ValidationException(RANGE_ERROR_MESSAGE);
        }
    }

    public String getNameOfIndex(int index) {
        return values.get(index).getValue();
    }

    public int getIndexOfName(String name) {
        return IntStream.range(0, values.size())
                .filter(idx -> values.get(idx).getValue().equals(name))
                .findAny()
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR_MESSAGE));
    }

    public Map<Integer, String> getPlayerSequenceAndName() {
        return IntStream.range(0, values.size())
                .boxed()
                .collect(Collectors.toMap(index -> index, index -> values.get(index).getValue()));
    }

    public int getCount() {
        return values.size();
    }
}
