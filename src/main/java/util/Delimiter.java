package util;

import java.util.regex.Pattern;

public enum Delimiter {
    COMMA(",", "쉼표", Pattern.compile("^[a-zA-Z가-힣\\d]+(,[a-zA-Z가-힣\\d]+)*$"));

    private final String value;
    private final String korName;
    private final Pattern pattern;

    Delimiter(String value, String korName, Pattern pattern) {
        this.value = value;
        this.korName = korName;
        this.pattern = pattern;
    }

    public String getValue() {
        return this.value;
    }

    public String getKorName() {
        return this.korName;
    }

    public boolean matches(String value) {
        return pattern.matcher(value).matches();
    }
}
