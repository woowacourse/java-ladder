package model;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private static final String DELIMITER = ",";

    private final List<Prize> prizes;

    public Prizes(String inputPrizesText) {
        prizes =  Arrays.stream(inputPrizesText.split(DELIMITER))
                .map(Prize::new)
                .toList();
    }

    public Prize findPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
