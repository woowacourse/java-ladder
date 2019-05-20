package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prizes {
    private static final String SPLIT_SEPARATOR = ",";

    private final List<Prize> prizes;

    public Prizes(String input) {
        this.prizes = addPrize(splitNames(input));
    }

    private static String[] splitNames(String names) {
        return names.split(SPLIT_SEPARATOR);
    }

    private List<Prize> addPrize(String[] prizeNames) {
        List<Prize> prizes = new ArrayList<>();
        Arrays.stream(prizeNames)
                .forEach(prizeName -> prizes.add(new Prize(prizeName)));
        return prizes;
    }

    public List<Prize> getPrizes() {
        return this.prizes;
    }

    public Prize getPrize(int index) {
        return this.prizes.get(index);
    }
}
