package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Power {
    RE_GAME("R"), QUIT("Q"), PRINT("P");

    private final String value;

    Power(String value) {
        this.value = value;
    }

    public static String printPowerMsg() {
        return String.format("결과를 다시 보려면 %s, 게임을 다시 하려면 %s, 게임을 끝내려면 %s를 입력하세요."
            , PRINT.value, RE_GAME.value, QUIT.value);
    }

    public static Power validate(String input) {
        return Arrays.stream(Power.values())
            .filter(power -> power.value.equalsIgnoreCase(input))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(getErrorPowerMsg()));
    }

    private static String getErrorPowerMsg() {
        List<String> values = Arrays.stream(Power.values())
            .map(Power::getValue)
            .collect(Collectors.toList());
        return String.join(",", values) + " 만 입력해주세요";
    }

    private String getValue() {
        return value;
    }
}
