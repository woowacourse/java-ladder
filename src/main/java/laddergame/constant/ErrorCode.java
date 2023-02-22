package laddergame.constant;

import java.util.Arrays;
import java.util.Map;

public enum ErrorCode {
    PLAYER_NAME_DUPLICATED("NAME_DUPLICATED", Map.of(
            LanguageCode.KOREAN.getCode(), "플레이어 이름이 중복되었습니다."
    )),
    NOT_NATURAL_NUMBER("NOT_NATURAL_NUMBER", Map.of(
            LanguageCode.KOREAN.getCode(), "자연수를 입력해 주세요."
    )),
    NOT_VALID_LADDER_LABEL_LENGTH("NOT_VALID_LABEL_LENGTH", Map.of(
            LanguageCode.KOREAN.getCode(), "입력값은 5글자 이하여야 합니다"
    )),
    NOT_VALID_PLAYER_COUNT("NOT_VALID_PLAYER_COUNT", Map.of(
            LanguageCode.KOREAN.getCode(), "2명 이상의 플레이어가 필요합니다."
    )),
    EMPTY_INPUT("EMPTY_INPUT", Map.of(
            LanguageCode.KOREAN.getCode(), "공백을 입력할 수 없습니다."
    )),
    PRIZE_COUNT_NOT_MATCHED("PRIZE_COUNT_NOT_MATCHED", Map.of(
            LanguageCode.KOREAN.getCode(), "입력된 사용자와 상품의 수가 다릅니다."
    )),
    NOT_VALID_ARGUMENT("NOT_VALID_ARGUMENT", Map.of(
            LanguageCode.KOREAN.getCode(), "올바른 값이 아닙니다."
    ));

    private static final String ERROR_MARKER = "[ERROR]";
    private static final String SPACE = " ";

    private final String code;
    private final Map<String, String> messages;

    ErrorCode(String code, Map<String, String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public static ErrorCode findByCode(String code) {
        return Arrays.stream(ErrorCode.values())
                .filter(errorCode -> errorCode.code.equals(code))
                .findFirst()
                .orElse(NOT_VALID_ARGUMENT);
    }

    public String getCode() {
        return code;
    }

    public String getMessage(String languageCode) {
        return ERROR_MARKER + SPACE + messages.getOrDefault(languageCode, code);
    }
}
