package model;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private static final String INPUT_PARSE_DELIMITER = ",";

    private final List<Prize> prizes;

    public Prizes(String inputPrizesText, int personCount) {
        prizes =  Arrays.stream(inputPrizesText.split(INPUT_PARSE_DELIMITER))
                .map(Prize::new)
                .toList();
    }

    public Prize findPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
