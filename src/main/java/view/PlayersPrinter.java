package view;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersPrinter {
    public static String from(List<String> rawPlayerNames) {
        return rawPlayerNames.stream()
                .map(PlayerPrinter::from)
                .collect(Collectors.joining(" "));
    }
}
