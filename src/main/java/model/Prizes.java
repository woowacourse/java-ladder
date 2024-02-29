package model;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private static final String DELIMITER = ",";

    private final List<Prize> prizes;

    public Prizes(String inputPrizesText,int personCount) {
        prizes =  Arrays.stream(inputPrizesText.split(DELIMITER))
                .map(Prize::new)
                .toList();
        validateLegalLength(personCount);
    }

    public Prize findPrizeByIndex(int index) {
        return prizes.get(index);
    }

    private void validateLegalLength(int personCount) {
        if (prizes.size() != personCount) {
            throw new IllegalArgumentException("참가자의 인원 수와 맞게 경품도 입력해주세요.");
        }
    }
}
