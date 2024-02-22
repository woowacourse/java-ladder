package ladder.domain;

import java.util.Arrays;

public enum LadderStepSymbol {

    LADDER_EXIST_SYMBOL(true, "-----"),
    LADDER_NONE_SYMBOL(false, "     ");

    final boolean status;
    final String symbol;

    LadderStepSymbol(boolean status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static String changeStatusToSymbol(boolean statusSymbol) {
        return Arrays.stream(values())
                .filter(symbol -> symbol.isStatus(statusSymbol))
                .findFirst()
                .map(LadderStepSymbol::getSymbol)
                .orElseThrow(() -> new IllegalArgumentException("status에 일치하는 symbol이 존재하지 않습니다."));
    }

    private boolean isStatus(boolean statusSymbol) {
        return status == statusSymbol;
    }

    private String getSymbol() {
        return symbol;
    }
}
