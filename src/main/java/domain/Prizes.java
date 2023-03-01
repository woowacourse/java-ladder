package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private static final String INVALID_COUNT_MESSAGE = "실행결과 수는 참여자 수와 같아야합니다.";
    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(List<String> names, Players players) {
        validateCount(names, players);
        initiate(names);
    }

    private void validateCount(List<String> names, Players players) {
        if (names.size() != players.getCount()) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private void initiate(List<String> names) {
        for (String name : names) {
            prizes.add(new Prize(name));
        }
    }

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toList());
    }

    public String getName(int index) {
        return prizes.get(index).getName();
    }

}
