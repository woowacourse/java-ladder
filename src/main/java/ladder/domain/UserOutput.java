package ladder.domain;

public enum UserOutput {
    DEMAND_PLAYER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    DEMAND_LADDER_HEIGHT("최대 사다리 높이는 얼마인가요?"),
    DEMAND_GAME_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    DEMAND_PLAYER_NAME_FOR_RESULT("\n결과를 보고 싶은 사람은?"),
    VIOLATE_PLAYER_NAMES("참가자 이름을 5글자 이내로 입력해주세요."),
    VIOLATE_LADDER_HEIGHT("사다리의 높이를 숫자로 입력해주세요."),
    VIOLATE_LADDER_HEIGHT_POSITIVE("사다리의 높이를 양수로 입력해주세요."),
    VIOLATE_PLAYER_NAME("잘못된 입력입니다."),
    VIOLATE_GAME_RESULTS("결과 값의 수가 참가자 수와 다릅니다."),
    VIOLATE_PLAYER_NAME_FOR_RESULT("참가자가 아닙니다."),
    PRINT_RESULT_INDEX("실행결과"),
    PRINT_GUIDE_FOR_END("종료를 원하히면 \'종료\' 를 입력해주세요."),
    PRINT_END_GAME("사다리 게임이 종료되었습니다.");

    private final String outputMessage;

    UserOutput(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
