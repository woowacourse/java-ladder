package ladder.domain.item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.player.Position;

/**
 * Result 는 결과의 이름, 위치들을 가지고 있는 클래스입니다
 */
public class Result {

    private static final String DIFFERENT_COUNT_MESSAGE = "플레이어의 수와 결과의 수가 다릅니다. 플레이어 : %d, 결과 : %d";
    private final List<Item> resultItems = new ArrayList<>();

    public Result(List<String> itemNames, int playerCount) {
        validateResultSize(itemNames, playerCount);
        for (int i = 0; i < itemNames.size(); i++) {
            resultItems.add(new Item(itemNames.get(i), i));
        }
    }

    private static void validateResultSize(List<String> itemNames, int playerCount) {
        if (itemNames.size() != playerCount) {
            throw new IllegalArgumentException(String.format(DIFFERENT_COUNT_MESSAGE, playerCount, itemNames.size()));
        }
    }

    public List<String> getNames() {
        return resultItems.stream()
                .map(Item::getName)
                .collect(Collectors.toList());
    }

    public String findByPosition(Position position) {
        return resultItems.stream()
                .filter(item -> item.isSamePosition(position))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getName();
    }
}
