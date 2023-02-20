package laddergame.constant;

public enum LanguageCode {
    KOREAN("kor");

    private final String code;

    LanguageCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
