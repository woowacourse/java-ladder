package ladder.domain.item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Result 는 결과의 이름, 위치들을 가지고 있는 클래스입니다
 */
public class Result {

    private final List<Item> resultItems = new ArrayList<>();

    public Result(List<String> itemNames) {
        for (int i = 0; i < itemNames.size(); i++) {
            resultItems.add(new Item(itemNames.get(i), i));
        }
    }

    public List<String> getNames() {
        return resultItems.stream()
                .map(Item::getName)
                .collect(Collectors.toList());
    }
}
