package ladder.view;

import ladder.domain.Players;

public enum ConsoleMessages {
    INPUT_NAME("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
    INPUT_REWARD("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    INPUT_PLAYER("결과를 보고 싶은 사람은?"),
    OUTPUT_LADDER("사다리 결과"),
    OUTPUT_RESULT("실행 결과"),
    ERR_NUMBER_FORMAT("높이는 숫자만 입력 가능합니다."),
    ERR_LADDER_RANGE("플레이어는 2명 이상, 사다리 높이는 1 이상이어야 합니다."),
    ERR_BLANK("공백을 입력할 수 없습니다."),
    ERR_REWARD_COUNT("플레이어와 보상의 수가 맞지 않습니다."),
    ERR_NAME_LENGTH("플레이어 이름은 최대 5글자 입니다."),
    ERR_ILLEGAL_NAME("플레이어 이름에 " + Players.FINISH_COMMAND + "를 사용할 수 없습니다."),
    ERR_NO_EXIST("일치하는 플레이어가 없습니다."),
    ERR_DUPLICATE("플레이어 이름을 중복 입력할 수 없습니다.");


    private String message;

    private ConsoleMessages(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
