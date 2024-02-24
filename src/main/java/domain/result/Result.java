package domain.result;

public class Result {
    private static final int MAX_RESULT_LENGTH = 5;

    private final String resultName;

    public Result(String resultName) {
        validate(resultName);
        this.resultName = resultName;
    }

    private void validate(String resultName) {
        if (resultName == null || resultName.isBlank()) {
            throw new IllegalArgumentException("빈 값을 결과로 사용할 수 없습니다.");
        }
        if (!resultName.strip().equals(resultName)) {
            throw new IllegalArgumentException("앞, 뒤 공백이 존재하는 이름을 결과로 사용할 수 없습니다.");
        }
        if (resultName.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("결과는 " + MAX_RESULT_LENGTH + "자 이하로 구성되어야 합니다.");
        }
    }
}
