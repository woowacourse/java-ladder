package controller;

import domain.ColumnPosition;
import domain.Height;
import domain.Player;
import domain.PlayerName;
import domain.Players;
import domain.Prize;
import domain.PrizeName;
import domain.Prizes;
import java.util.stream.IntStream;

public class InputMapper {
    private static final String NAME_DELIMITER = ",";
    private static final String RESULT_DELIMITER = ",";
    private static final int COLUMN_START = 0;

    public Players mapToNames(String target) {
        String[] playerNames = target.split(NAME_DELIMITER);
        return new Players(IntStream.range(COLUMN_START, playerNames.length)
                .mapToObj(index -> new Player(new PlayerName(playerNames[index]), new ColumnPosition(index)))
                .toList());
    }

    public PlayerName mapToName(String target) {
        return new PlayerName(target);
    }

    public Height mapToHeight(String target) {
        validateInputNumeric(target);
        return new Height(Integer.parseInt(target));
    }

    public Prizes mapToPrizes(String target) {
        String[] prizeNames = target.split(RESULT_DELIMITER);
        return new Prizes(IntStream.range(COLUMN_START, prizeNames.length)
                .mapToObj(index -> new Prize(new PrizeName(prizeNames[index]), new ColumnPosition(index)))
                .toList());
    }

    private void validateInputNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값이 아닙니다");
        }
    }
}
