package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum RungSymbol {

    RUNG_EXIST_SYMBOL(true, "-----"),
    RUNG_NONE_SYMBOL(false, "     ");

    final boolean status;
    final String symbol;

    RungSymbol(boolean status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static List<String> changeStatusListToSymbol(List<Boolean> rungsBuildStatus) {
        List<String> symbols = new ArrayList<>();

        for (Boolean buildStatus : rungsBuildStatus) {
            symbols.add(changeStatusToSymbol(buildStatus));
        }

        return symbols;
    }

    public static String changeStatusToSymbol(boolean buildStatus) {
        return Arrays.stream(values())
                .filter(symbol -> symbol.isStatus(buildStatus))
                .findFirst()
                .map(RungSymbol::getSymbol)
                .orElseThrow(() -> new IllegalArgumentException("bool 상태와 일치하는 심볼이 존재하지 않습니다."));
    }

    private boolean isStatus(boolean statusSymbol) {
        return status == statusSymbol;
    }

    private String getSymbol() {
        return symbol;
    }
}
