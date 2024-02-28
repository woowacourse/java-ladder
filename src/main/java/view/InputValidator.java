package view;

import java.util.List;

public class InputValidator {

    public static void validatePlayerName(List<String> playerNames, String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("참여자 이름을 입력해 주세요.");
        }

        if (!playerNames.contains(input) && !input.equals("all")) {
            throw new IllegalArgumentException("참여자 목록에 없는 이름입니다.");
        }
    }
}
