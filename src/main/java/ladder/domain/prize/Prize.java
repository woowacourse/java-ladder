package ladder.domain.prize;

import java.util.regex.Pattern;

public class Prize {

    private static final String ALPHABET_FORMAT = "^[ㄱ-ㅎ가-힣0-9a-zA-Z ]+$";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    private final String prizeName;

    public Prize(String prizeName) {
        validatePrizeName(prizeName);
        this.prizeName = prizeName;
    }

    public String getPrizeName() {
        return this.prizeName;
    }

    private void validatePrizeName(String name) {
        validatePrizeNameLength(name);
        validateNameEngKorNumFormat(name);
        validateBlankInPrizeName(name);
    }

    private void validatePrizeNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateNameEngKorNumFormat(String name) {
        if (!Pattern.matches(ALPHABET_FORMAT, name)) {
            throw new IllegalArgumentException("[ERROR] 실행결과의 이름은 한글, 영문 대소문자, 숫자만 허용합니다.");
        }
    }

    private void validateBlankInPrizeName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 이름 내에는 공백을 허용하지 않습니다.");
        }
    }
}
