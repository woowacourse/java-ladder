package ladderGame;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRowFactory {
    public static LadderRow newInstance(int columns) {
        return new LadderRow(Stream.generate(() -> false)
                .limit(columns).collect(Collectors.toList()));
    }
}
