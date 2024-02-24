package domain;

public class GameResult {

    private final String name;

    public GameResult(String resultName) {
        validateNameLength(resultName);

        this.name = resultName;
    }

    private void validateNameLength(String resultName) {
        if (resultName.trim().isEmpty()) {
            throw new IllegalArgumentException("실행 결과는 공백을 제외한 1자 이상 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
