package ladder.domain;

public class ResultName {
    private static final String NAME_CONTAIN_SPACE_ERROR = "결과명 공백 포함 오류";
    private static final String NAME_LENGTH_ERROR = "결과명 길이 5초과 오류";
    private static final String EMPTY_NAME_ERROR = "빈 결과명 오류";
    private String name;

    public ResultName(String name) {
        checkEmptyName(name);
        checkNameLength(name);
        checkNameContainSpace(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameContainSpace(String name) {
        if(name.contains(" ")){
            throw new IllegalArgumentException(NAME_CONTAIN_SPACE_ERROR);
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void checkEmptyName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    @Override
    public String toString() {
        return String.format("%6s",this.name);
    }
}
