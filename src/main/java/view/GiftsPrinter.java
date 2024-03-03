package view;

import java.util.List;
import java.util.stream.Collectors;

public class GiftsPrinter {
    public static String from(List<String> rawGiftNames) {
        return rawGiftNames.stream()
                .map(GiftPrinter::from)
                .collect(Collectors.joining(" "));
    }
}
