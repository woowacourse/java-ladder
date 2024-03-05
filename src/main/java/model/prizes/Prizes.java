package model.prizes;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private static final String INPUT_PARSE_DELIMITER = ",";

    private final List<Prize> prizes;

    public Prizes(String prizesText) {
        prizes = Arrays.stream(prizesText.split(INPUT_PARSE_DELIMITER))
                .map(Prize::new)
                .toList();
    }

    public Prize findPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
