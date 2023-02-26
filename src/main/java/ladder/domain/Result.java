package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Result 는 결과의 이름, 위치들을 가지고 있는 클래스입니다
 */
class Result {

    private static final String DIFFERENT_COUNT_MESSAGE = "플레이어의 수와 결과의 수가 다릅니다. 플레이어 : %d, 결과 : %d";

    private final Map<Position, Item> resultItems = new LinkedHashMap<>();

    Result(List<String> itemNames, int playerCount) {
        validateResultSize(itemNames, playerCount);
        for (int i = 0; i < itemNames.size(); i++) {
            resultItems.put(Position.valueOf(i), new Item(itemNames.get(i), i));
        }
    }

    private static void validateResultSize(List<String> itemNames, int playerCount) {
        if (itemNames.size() != playerCount) {
            throw new IllegalArgumentException(String.format(DIFFERENT_COUNT_MESSAGE, playerCount, itemNames.size()));
        }
    }

    List<String> getNames() {
        return resultItems.values()
                .stream()
                .map(Item::getName)
                .collect(Collectors.toList());
    }

    String findByPosition(Position position) {
        return resultItems.get(position)
                .getName();
    }
}
